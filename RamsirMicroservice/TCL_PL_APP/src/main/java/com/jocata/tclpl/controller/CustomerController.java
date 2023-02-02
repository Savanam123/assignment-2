package com.jocata.tclpl.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.tcldl.entity.CpAddress;
import com.jocata.tcldl.entity.CpIdentity;
import com.jocata.tcldl.entity.Customer;
import com.jocata.tcldl.service.CustomerService;
import com.jocata.tclpl.service.CreateLeadServiceCaller;
import com.jocata.tclpl.service.CreateWebtopServiceCaller;
import com.jocata.tclutils.request.CreateLeadRequest;
import com.jocata.tclutils.request.CreateWebtopRequest;
import com.jocata.tclutils.request.CustomerAddress;
import com.jocata.tclutils.request.CustomerDetailsRequest;
import com.jocata.tclutils.request.CustomerIdentity;
import com.jocata.tclutils.response.CreateLeadResponse;
import com.jocata.tclutils.response.CreateWebtopResponse;
import com.jocata.tclutils.response.CustomerDetailsResponse;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CreateLeadServiceCaller createLeadServiceCaller;
	
	@Autowired
	CreateWebtopServiceCaller createWebtopServiceCaller;
	
	@PostMapping("/saveCustomerDetails")
	public ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerDetailsRequest customerDetailsRequest){
		CustomerDetailsResponse customerDetailsResponse = new CustomerDetailsResponse();
		
		//create objects of entities - customer, customer addresse, customer identity, and set req values
		Customer customer = null;
		Integer cpId = null;
		String PAN = "";
		String city = "";
		String state = "";
		String pincode ="";
		
		customer  = customerService.getCustomerByMobileNo(customerDetailsRequest.getMobileNo());
		
		if(customer == null) {
			customer = new Customer();
		}
		
		customer.setFirstname(customerDetailsRequest.getFirstname());
		customer.setLastname(customerDetailsRequest.getLastname());
		customer.setDob(customerDetailsRequest.getDob());
		customer.setMiddlename(customerDetailsRequest.getMiddlename());
		customer.setMobileno(customerDetailsRequest.getMobileNo());
		customer.setEmailid(customerDetailsRequest.getEmailId());
		
		if(customer.getId() != null) {
			cpId = customer.getId();
			customerService.updateCustomer(customer);
			
			customerService.deleteCpAddressByCpId(customer.getId());
			customerService.deleteCpIdentityBYCpId(customer.getId());
		}
		else {
			cpId = (Integer)customerService.saveCustomer(customer);
			customer.setId(cpId);
		}
		
		//saving or updating customer details is over, its time to save or update addresses and identities
		
		if(customerDetailsRequest.getAddresses()!= null && customerDetailsRequest.getAddresses().size() >0) {
			for(CustomerAddress custAddress : customerDetailsRequest.getAddresses()) {
				CpAddress cpAddress = new CpAddress();
				cpAddress.setCustomer(customer);
				cpAddress.setAddress(custAddress.getAddress());
				cpAddress.setAddresstype(custAddress.getAddresstype());
				cpAddress.setCity(custAddress.getCity());
				cpAddress.setState(custAddress.getState());
				cpAddress.setPincode(custAddress.getPincode());
				
				if(custAddress.getAddresstype().equalsIgnoreCase("residential")) {
					pincode = custAddress.getPincode();
					city = custAddress.getCity();
					state = custAddress.getState();
				}
				
				customerService.saveCpAddress(cpAddress);
			}
		}		
		if(customerDetailsRequest.getIdentities()!= null && customerDetailsRequest.getIdentities().size() >0) {
			for(CustomerIdentity custIdentity : customerDetailsRequest.getIdentities()) {
				CpIdentity cpIdentity = new CpIdentity();
				cpIdentity.setCustomer(customer);
				cpIdentity.setIdnum(custIdentity.getCardnumber());
				cpIdentity.setIdtype(custIdentity.getIdtype());
				cpIdentity.setNameoncard(custIdentity.getNameoncard());
				
				if(custIdentity.getIdtype().equalsIgnoreCase("pan")) { 
					PAN = custIdentity.getCardnumber();
				}
				
				customerService.saveCpIdentity(cpIdentity);
			}
		}
		
		customerDetailsResponse.setStatus("success");
		customerDetailsResponse.setMessage("Customer saved successfully with ID: " + cpId);
				
		//call the create lead service, get the response and save it to customer table
		CreateLeadRequest leadRequest = new CreateLeadRequest();
		leadRequest.setRefId("PL_" + cpId + "_"+ new Date().getTime());
		leadRequest.setFirstName(customer.getFirstname());
		leadRequest.setMiddleName(customer.getMiddlename());
		leadRequest.setLastName(customer.getLastname());
		leadRequest.setMobileNo(customer.getMobileno());
		leadRequest.setEmailId(customer.getEmailid());
		leadRequest.setCity(city);
		leadRequest.setState(state);
		leadRequest.setPincode(pincode);
		leadRequest.setpAN(PAN);
		leadRequest.setSource("email");
		leadRequest.setSubsource("email");
		leadRequest.setProduct("LOAN AGAINST SHARE");
		
		CreateLeadResponse leadResponse = createLeadServiceCaller.createLead(leadRequest);
		if(leadResponse != null && leadResponse.getlAS_Create_Lead_SFDC()!= null 
								&& leadResponse.getlAS_Create_Lead_SFDC().getLeadId()!= null) {
			
			customer.setLeadid(leadResponse.getlAS_Create_Lead_SFDC().getLeadId());
			customerService.updateCustomer(customer);
			
			customerDetailsResponse.setLeadid(leadResponse.getlAS_Create_Lead_SFDC().getLeadId());
			
			//call the create webtop service, get the response and save it to customer table
			CreateWebtopRequest webtopRequest = new CreateWebtopRequest();
			webtopRequest.setApplicantName(customer.getFirstname() + " " + customer.getMiddlename() + " " + customer.getLastname());
			webtopRequest.setDmsBranchCode("284");
			webtopRequest.setSageProduct("Business Loans");
			webtopRequest.setApplicantType("1");
			webtopRequest.setDsaName("");
			
			CreateWebtopResponse webtopResponse = createWebtopServiceCaller.createWebtop(webtopRequest);
			if(webtopResponse != null && webtopResponse.getWebtopNo() != null) {
				customer.setWebtopid(webtopResponse.getWebtopNo());
				customerService.updateCustomer(customer);
				
				customerDetailsResponse.setWebtopid(webtopResponse.getWebtopNo());
				
			}else {
				customerDetailsResponse.setStatus("Failed");
				customerDetailsResponse.setError("Create Webtop Service call failed");
			}
			
		}
		else {	
			customerDetailsResponse.setStatus("Failed");
			customerDetailsResponse.setError("Create Lead Service call failed");
		} 
			
		//return response back to postman
		return new ResponseEntity<CustomerDetailsResponse>(customerDetailsResponse, HttpStatus.CREATED);
	}
	
	

}
