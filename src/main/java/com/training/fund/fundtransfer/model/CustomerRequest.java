package com.training.fund.fundtransfer.model;

public class CustomerRequest {
	
	private String fname;
	
	private String lname;
	
	private String address;
	
	private String adhar;
	
	private String pan;
	
	private Integer age;
	
	public Integer fromCid;

	public Integer amount;
	
	public Integer toCid;

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
	
	

	public Integer getFromCid() {
		return fromCid;
	}

	public void setFromCid(Integer fromCid) {
		this.fromCid = fromCid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getToCid() {
		return toCid;
	}

	public void setToCid(Integer toCid) {
		this.toCid = toCid;
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

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
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
