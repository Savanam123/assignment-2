package com.jocata.tcldl.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jocata.tcldl.dao.CustomerDAO;
import com.jocata.tcldl.entity.CpAddress;
import com.jocata.tcldl.entity.CpIdentity;
import com.jocata.tcldl.entity.Customer;
import com.jocata.tcldl.utils.HibernateUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	HibernateUtils hibernateUtils;

	@Override
	public Serializable saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return hibernateUtils.save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		hibernateUtils.update(customer);
	}

	@Override
	public Customer getCustomerByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		return hibernateUtils.getEntityById(Customer.class, cpId);
	}

	@Override
	public Customer getCustomerByMobileNo(String mobileNo) {
		// TODO Auto-generated method stub
		return hibernateUtils.getEntityByHql("from Customer c where c.mobileno='" + mobileNo + "'");
	}
	
	@Override
	public Customer getCustomerByEmailId(String eMailId) {
		// TODO Auto-generated method stub
		return hibernateUtils.getEntityByHql("from Customer c where c.emailid='" + eMailId + "'");
	}

	@Override
	public Serializable saveCpIdentity(CpIdentity cpIdentity) {
		// TODO Auto-generated method stub
		return hibernateUtils.save(cpIdentity);
	}

	@Override
	public Serializable saveCpAddress(CpAddress cpAddress) {
		// TODO Auto-generated method stub
		return hibernateUtils.save(cpAddress);
	}


	@Override
	public List<CpIdentity> loadCpIdentityByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		return hibernateUtils.loadEntityByHql("from CpIdentity cpidentity where cpidentity.customer.id='" + cpId + "'");
	}

	@Override
	public List<CpAddress> loadCpAddressByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		return hibernateUtils.loadEntityByHql("from CpAddress cpaddr where cpaddr.customer.id='" + cpId + "'");
	}

	@Override
	public void deleteCpIdentityBYCpId(Integer cpId) {
		// TODO Auto-generated method stub
		hibernateUtils.deleteByHql("delete from CpIdentity cpidentity where cpidentity.customer.id='"+ cpId +"'");
	}

	@Override
	public void deleteCpAddressByCpId(Integer cpId) {
		// TODO Auto-generated method stub
		hibernateUtils.deleteByHql("delete from CpAddress cpaddr where cpaddr.customer.id='"+ cpId +"'"); 
	}



}
