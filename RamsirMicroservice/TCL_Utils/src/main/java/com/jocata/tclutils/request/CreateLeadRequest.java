package com.jocata.tclutils.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class CreateLeadRequest implements Serializable{

	private static final long serialVersionUID = -469742102651296454L;
	
	 	@JsonProperty("RefId") 
	    public String refId;
	 	
	    @JsonProperty("FirstName") 
	    public String firstName;
	    
	    @JsonProperty("MiddleName") 
	    public String middleName;
	    
	    @JsonProperty("LastName") 
	    public String lastName;
	    
	    @JsonProperty("MobileNo") 
	    public String mobileNo;
	    
	    @JsonProperty("EmailId") 
	    public String emailId;
	    
	    @JsonProperty("Pincode") 
	    public String pincode;
	    
	    @JsonProperty("City") 
	    public String city;
	    
	    @JsonProperty("State") 
	    public String state;
	    
	    @JsonProperty("PAN") 
	    public String pAN;
	    
	    @JsonProperty("Source") 
	    public String source;
	    
	    @JsonProperty("Subsource") 
	    public String subsource;
	    
	    @JsonProperty("Product") 
	    public String product;
	    
		public String getRefId() {
			return refId;
		}
		public void setRefId(String refId) {
			this.refId = refId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
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
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getpAN() {
			return pAN;
		}
		public void setpAN(String pAN) {
			this.pAN = pAN;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getSubsource() {
			return subsource;
		}
		public void setSubsource(String subsource) {
			this.subsource = subsource;
		}
		public String getProduct() {
			return product;
		}
		public void setProduct(String product) {
			this.product = product;
		}
	    
	    

}
