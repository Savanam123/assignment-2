package com.jocata.tclutils.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CreateWebtopResponse implements Serializable{

	private static final long serialVersionUID = -5164880873810284839L;
	
    public String retStatus;
    public String dmsResponse;
    public String errorMessage;
    public String objectID;
    public String sysErrorCode;
    public String sysErrorMessage;
    public String webtopNo;
    
	public String getRetStatus() {
		return retStatus;
	}
	public void setRetStatus(String retStatus) {
		this.retStatus = retStatus;
	}
	public String getDmsResponse() {
		return dmsResponse;
	}
	public void setDmsResponse(String dmsResponse) {
		this.dmsResponse = dmsResponse;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getObjectID() {
		return objectID;
	}
	public void setObjectID(String objectID) {
		this.objectID = objectID;
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
	public String getWebtopNo() {
		return webtopNo;
	}
	public void setWebtopNo(String webtopNo) {
		this.webtopNo = webtopNo;
	}
    
    

}
