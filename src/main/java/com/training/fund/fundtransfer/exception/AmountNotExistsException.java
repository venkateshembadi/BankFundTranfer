package com.training.fund.fundtransfer.exception;

public class AmountNotExistsException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public AmountNotExistsException() {
		super();
	}
	
	public AmountNotExistsException(String errorMessage) {
		super(errorMessage);
		
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	

}
