package com.jocata.tclutils.response;

import java.io.Serializable;

public class CustomerDetailsResponse implements Serializable{

	private static final long serialVersionUID = -1001601136735714828L;
	
    public String status;
    public String message;
    public String leadid;
    public String webtopid;
    public String error;
    
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLeadid() {
		return leadid;
	}
	public void setLeadid(String leadid) {
		this.leadid = leadid;
	}
	public String getWebtopid() {
		return webtopid;
	}
	public void setWebtopid(String webtopid) {
		this.webtopid = webtopid;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
    
    

}
