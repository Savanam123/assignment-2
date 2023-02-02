package com.jocata.tclutils.request;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CustomerDetailsRequest implements Serializable{
	

	private static final long serialVersionUID = -5591354478870884325L;
	
    public String firstname;
    public String middlename;
    public String lastname;
    public String mobileNo;
    public String emailId;
    public String dob;
    
    public List<CustomerAddress> addresses;
    public List<CustomerIdentity> identities;
    
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<CustomerAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<CustomerAddress> addresses) {
		this.addresses = addresses;
	}
	public List<CustomerIdentity> getIdentities() {
		return identities;
	}
	public void setIdentities(List<CustomerIdentity> identities) {
		this.identities = identities;
	}
    
    

}
