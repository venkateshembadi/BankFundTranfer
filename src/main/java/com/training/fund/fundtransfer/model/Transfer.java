package com.training.fund.fundtransfer.model;

public class Transfer {

	public Integer fromCid;

	private long fromAccountNumber;

	public Integer amount;

	public long toAccountNumber;
	
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
