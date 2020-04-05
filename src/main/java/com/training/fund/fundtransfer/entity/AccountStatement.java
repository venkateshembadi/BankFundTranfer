package com.training.fund.fundtransfer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ACCOUNT_STATEMENT")
public class AccountStatement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STATEMENT_ID")
	private Integer statementId;

	@Column(name = "ACCOUNTAMOUNT")
	private Integer accountAmt;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "STATUS")
	private String status;

	@ManyToOne
	@JoinColumn(name = "accountId")
	@JsonIgnore
	public Account account;

	public Integer getAccountAmt() {
		return accountAmt;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAccountAmt(Integer accountAmt) {
		this.accountAmt = accountAmt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
