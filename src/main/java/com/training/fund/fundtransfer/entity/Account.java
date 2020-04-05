package com.training.fund.fundtransfer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "ACCOUNT_NUMBER")
	private long accountNumber;

	@OneToOne
	@JoinColumn(name = "cid")
	@JsonIgnore
	public Customer customer;

	@Column(name = "BALANCE")
	private Integer balance;

	@OneToMany(mappedBy ="account",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public List<AccountStatement> statusAccount;

	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountId() {
		return accountId;
	}
	
	
	public List<AccountStatement> getStatusAccount() {
		return statusAccount;
	}

	public void setStatusAccount(List<AccountStatement> statusAccount) {
		this.statusAccount = statusAccount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
