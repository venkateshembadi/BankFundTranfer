package com.training.fund.fundtransfer.model;


import javax.validation.constraints.NotNull;

public class Transfer {

	@NotNull(message="Please from customer Id")
	public Integer fromCid;

	
	private long fromAccountNumber;

	@NotNull(message="Please from customer amount")
	public Integer amount;

	public long toAccountNumber;
	
	@NotNull(message="Please To customer Id")
	public Integer toCid;
	
		
	public Integer getFromCid() {
		return fromCid;
	}

	public void setFromCid(Integer fromCid) {
		this.fromCid = fromCid;
	}

	public Integer getToCid() {
		return toCid;
	}

	public void setToCid(Integer toCid) {
		this.toCid = toCid;
	}

	public long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
