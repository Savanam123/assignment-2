package com.jocata.tclutils.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class LASCreateLeadSFDC {
	
    @JsonProperty("Status") 
    public String status;
    
    @JsonProperty("Message") 
    public String message;
    
    @JsonProperty("LeadId") 
    public String leadId;
    
    @JsonProperty("RefID") 
    public String refID;
    
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
	public String getLeadId() {
		return leadId;
	}
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	public String getRefID() {
		return refID;
	}
	public void setRefID(String refID) {
		this.refID = refID;
	}

    
}
