package com.training.fund.fundtransfer.exception;

public class CustomerException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public CustomerException() {
		super();
	}
	
	public CustomerException(String errorMessage) {
		super();
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	


}
