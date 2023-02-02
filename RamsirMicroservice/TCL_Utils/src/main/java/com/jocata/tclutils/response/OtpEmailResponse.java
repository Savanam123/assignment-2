package com.jocata.tclutils.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class OtpEmailResponse implements Serializable{

	private static final long serialVersionUID = -5613464860734655668L;
	
    public String retStatus;
    public String otpRefNo;
    public Object errorMessage;
    public String sysErrorCode;
    public String sysErrorMessage;
    
	public String getRetStatus() {
		return retStatus;
	}
	public void setRetStatus(String retStatus) {
		this.retStatus = retStatus;
	}
	public String getOtpRefNo() {
		return otpRefNo;
	}
	public void setOtpRefNo(String otpRefNo) {
		this.otpRefNo = otpRefNo;
	}
	public Object getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(Object errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSysErrorCode() {
		return sysErrorCode;
	}
	public void setSysErrorCode(String sysErrorCode) {
		this.sysErrorCode = sysErrorCode;
	}
	public String getSysErrorMessage() {
		return sysErrorMessage;
	}
	public void setSysErrorMessage(String sysErrorMessage) {
		this.sysErrorMessage = sysErrorMessage;
	}
    
    

}
