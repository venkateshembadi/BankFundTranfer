package com.training.fund.fundtransfer.model;

import java.util.Date;

public class AccountStatementReq {
	
	private Date startDate; 

	private Date endDate;
	
	private Integer accountId;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	


}
