package com.jocata.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Transactional
@Table(name="CustomerIndetity")
public class CustomerIdentity  {

//	private static final long serialVersionUID = 3813068533269777437L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String idnum;
	
	private String nameoncard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private CustomerDetails customerDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private IdentityTypes identitytypes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public IdentityTypes getIdentitytypes() {
		return identitytypes;
	}

	public void setIdentitytypes(IdentityTypes identitytypes) {
		this.identitytypes = identitytypes;
	}
	
	
	

}
