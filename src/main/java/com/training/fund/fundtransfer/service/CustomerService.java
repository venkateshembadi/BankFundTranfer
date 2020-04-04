package com.training.fund.fundtransfer.service;

import java.util.List;

import com.training.fund.fundtransfer.entity.Customer;
import com.training.fund.fundtransfer.model.CustomerRequest;
import com.training.fund.fundtransfer.model.Transfer;

public interface CustomerService {
	
	public Customer registerCustomer(CustomerRequest account);
	
	public Transfer transferAmount(Transfer transfer);
	
	List<Customer> fetchAllAccountDetails();

}
