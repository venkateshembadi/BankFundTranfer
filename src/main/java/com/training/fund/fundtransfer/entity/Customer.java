package com.training.fund.fundtransfer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "CUSTOMER")
public class Customer {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer cid;

	@Column(name = "FNAME")
	private String fname;

	@Column(name = "LNAME")
	private String lname;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "AADHAR")
	private String aadhar;

	@Column(name = "PAN")
	private String pan;

	@Column(name = "AGE")
	private Integer age;

	//@OneToOne
	@OneToOne(mappedBy = "customer",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	public Account account;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
