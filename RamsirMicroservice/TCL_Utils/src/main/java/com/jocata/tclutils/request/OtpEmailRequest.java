package com.jocata.tclutils.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class OtpEmailRequest implements Serializable{

	private static final long serialVersionUID = -5562096744711927715L;
	
	@JsonProperty("EmailId")
	private String emailId;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
