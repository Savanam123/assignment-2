package com.jocata.tclutils.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateLeadResponse implements Serializable{

	private static final long serialVersionUID = -8521440942499728270L;
	
	@JsonProperty("LAS_Create_Lead_SFDC") 
    public LASCreateLeadSFDC lAS_Create_Lead_SFDC;
	
    @JsonProperty("RetStatus") 
    public String retStatus;
    
    public String sysErrorMessage;
    public String sysErrorCode;
    
	public LASCreateLeadSFDC getlAS_Create_Lead_SFDC() {
		return lAS_Create_Lead_SFDC;
	}
	public void setlAS_Create_Lead_SFDC(LASCreateLeadSFDC lAS_Create_Lead_SFDC) {
		this.lAS_Create_Lead_SFDC = lAS_Create_Lead_SFDC;
	}
	public String getRetStatus() {
		return retStatus;
	}
	public void setRetStatus(String retStatus) {
		this.retStatus = retStatus;
	}
	public String getSysErrorMessage() {
		return sysErrorMessage;
	}
	public void setSysErrorMessage(String sysErrorMessage) {
		this.sysErrorMessage = sysErrorMessage;
	}
	public String getSysErrorCode() {
		return sysErrorCode;
	}
	public void setSysErrorCode(String sysErrorCode) {
		this.sysErrorCode = sysErrorCode;
	}

    
}
