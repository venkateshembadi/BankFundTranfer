package com.training.fund.fundtransfer.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class CustomerRequest {

	@NotBlank(message = "First name can not be Blank")
	private String fname;

	@NotBlank(message = "Last name can not be Blank")
	private String lname;

	private String address;

	@NotBlank(message = "Aadhar can not be Blank")
	private String aadhar;

	private String pan;

	private Integer age;

	public Integer amount;

	@Valid
	private AccountReq accountRequest;

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
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

	public AccountReq getAccountRequest() {
		return accountRequest;
	}

	public void setAccountRequest(AccountReq accountRequest) {
		this.accountRequest = accountRequest;
	}

}
