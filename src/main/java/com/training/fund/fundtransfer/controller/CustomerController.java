package com.training.fund.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.fund.fundtransfer.entity.Customer;
import com.training.fund.fundtransfer.exception.AmountNotExistsException;
import com.training.fund.fundtransfer.exception.CustomerException;
import com.training.fund.fundtransfer.model.CustomerRequest;
import com.training.fund.fundtransfer.model.Transfer;
import com.training.fund.fundtransfer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	public CustomerServiceImpl customerService;

	@PostMapping
	public ResponseEntity<?> registerCustomer(@RequestBody CustomerRequest request) {
		ResponseEntity<?> responseEntity;

		try {
			Customer customerRes = customerService.registerCustomer(request);
			responseEntity = new ResponseEntity<Customer>(customerRes, HttpStatus.CREATED);
		} catch (CustomerException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

	@PutMapping
	public ResponseEntity<?> transferAmount(@RequestBody Transfer transfer) {
		ResponseEntity<?> responseEntity;
		try {
			Transfer customerRes = customerService.transferAmount(transfer);
			responseEntity = new ResponseEntity<Transfer>(customerRes, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new AmountNotExistsException("Please enter valid amount");

		}

		return responseEntity;
	}

}
