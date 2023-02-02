package com.jocata.tcldl.service.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jocata.tcldl.dao.CustomerDAO;
import com.jocata.tcldl.entity.CpAddress;
import com.jocata.tcldl.entity.CpIdentity;
import com.jocata.tcldl.entity.Customer;
import com.jocata.tcldl.service.CustomerService;

@Service
class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public Serializable saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.saveCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerByCpId(cpId);
	}

	@Override
	public Customer getCustomerByMobileNo(String mobileNo) {
		// TODO Auto-generated method stub
		//here we write data validation code to check if mobile number is proper
		return customerDAO.getCustomerByMobileNo(mobileNo);
	}

	@Override
	public Customer getCustomerByEmailId(String eMailId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerByEmailId(eMailId);
	}

	@Override
	public Serializable saveCpIdentity(CpIdentity cpIdentity) {
		// TODO Auto-generated method stub
		return customerDAO.saveCpIdentity(cpIdentity);
	}

	@Override
	public Serializable saveCpAddress(CpAddress cpAddress) {
		// TODO Auto-generated method stub
		return customerDAO.saveCpAddress(cpAddress);
	}

	@Override
	public List<CpIdentity> loadCpIdentityByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		return customerDAO.loadCpIdentityByCpId(cpId);
	}

	@Override
	public List<CpAddress> loadCpAddressByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		return customerDAO.loadCpAddressByCpId(cpId);
	}

	@Override
	public void deleteCpIdentityBYCpId(Integer cpId) {
		// TODO Auto-generated method stub
		customerDAO.deleteCpIdentityBYCpId(cpId);
	}

	@Override
	public void deleteCpAddressByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		customerDAO.deleteCpAddressByCpId(cpId);
	}

}
