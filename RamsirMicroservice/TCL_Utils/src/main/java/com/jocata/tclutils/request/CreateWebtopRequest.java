package com.jocata.tclutils.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CreateWebtopRequest implements Serializable{

	private static final long serialVersionUID = -4237298960713004129L;
	
    public String dmsBranchCode;
    public String sageProduct;
    public String applicantName;
    public String applicantType;
    public String dsaName;
    
	public String getDmsBranchCode() {
		return dmsBranchCode;
	}
	public void setDmsBranchCode(String dmsBranchCode) {
		this.dmsBranchCode = dmsBranchCode;
	}
	public String getSageProduct() {
		return sageProduct;
	}
	public void setSageProduct(String sageProduct) {
		this.sageProduct = sageProduct;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getApplicantType() {
		return applicantType;
	}
	public void setApplicantType(String applicantType) {
		this.applicantType = applicantType;
	}
	public String getDsaName() {
		return dsaName;
	}
	public void setDsaName(String dsaName) {
		this.dsaName = dsaName;
	}
    
    

}
