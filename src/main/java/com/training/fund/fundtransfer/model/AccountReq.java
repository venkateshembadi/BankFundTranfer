package com.training.fund.fundtransfer.model;

import javax.validation.constraints.NotBlank;

public class AccountReq {
	
	@NotBlank(message="Bank Name can not be Blank")
	private String bankName;
	
	private Integer accountNumber;
	
	private String accountType;
	
	private Integer balance;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	
	
	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
