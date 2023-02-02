package com.jocata.tcldl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = -5657858984296032234L;
	
	private Integer id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String mobileno;
	private String emailid;
	private String dob;
	
	private String leadid;
	private String webtopid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
}
