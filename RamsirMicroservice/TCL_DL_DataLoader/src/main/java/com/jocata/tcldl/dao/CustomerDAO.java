package com.jocata.tcldl.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jocata.tcldl.entity.CpAddress;
import com.jocata.tcldl.entity.CpIdentity;
import com.jocata.tcldl.entity.Customer;

@Component
public interface CustomerDAO {

	public Serializable saveCustomer(Customer customer);
	public void updateCustomer(Customer customer); //to update the leadId, webtopId

	public Customer getCustomerByCpId(Integer cpId);
	public Customer getCustomerByMobileNo(String mobileNo);
	public Customer getCustomerByEmailId(String eMailId);
	
	public Serializable saveCpIdentity(CpIdentity cpIdentity);
	public Serializable saveCpAddress(CpAddress cpAddress);
	
	public void deleteCpIdentityBYCpId(Integer cpId);
	public void deleteCpAddressByCpId(Integer cpId);
	
	public List<CpIdentity> loadCpIdentityByCpId(Integer cpId);
	public List<CpAddress> loadCpAddressByCpId(Integer cpId);
	
	
}
