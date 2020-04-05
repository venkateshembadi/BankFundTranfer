package com.training.fund.fundtransfer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.fund.fundtransfer.entity.AccountStatement;
import com.training.fund.fundtransfer.entity.Customer;
import com.training.fund.fundtransfer.exception.AmountNotExistsException;
import com.training.fund.fundtransfer.exception.CustomerException;
import com.training.fund.fundtransfer.model.AccountStatementReq;
import com.training.fund.fundtransfer.model.CustomerRequest;
import com.training.fund.fundtransfer.model.Transfer;
import com.training.fund.fundtransfer.service.CustomerServiceImpl;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	public CustomerServiceImpl customerService;

	@PostMapping
	public ResponseEntity<?> registerCustomer(@RequestBody @Valid CustomerRequest request) {
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
	public ResponseEntity<?> transferAmount(@RequestBody @Valid Transfer transfer) {
		ResponseEntity<?> responseEntity;
		try {
			Transfer customerRes = customerService.transferAmount(transfer);
			responseEntity = new ResponseEntity<Transfer>(customerRes, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new AmountNotExistsException("Please enter valid amount");

		}

		return responseEntity;
	}

	@GetMapping
	public ResponseEntity<?> fetchAllAccountDetails() {
		ResponseEntity<?> responseEntity;
		List<Customer> list = customerService.fetchAllAccountDetails();
		return responseEntity = new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/accdetails/{cid}")
	public ResponseEntity<?> fetchAccountDetails(@PathVariable("cid") Integer cid) {
		ResponseEntity<?> responseEntity;
		Customer custRes = customerService.fetchAccountDetails(cid);
		return responseEntity = new ResponseEntity<Customer>(custRes, HttpStatus.OK);
	}
	
	@PutMapping(value="/statement")
	public ResponseEntity<?> fetchAccountStatement(@RequestBody AccountStatementReq account) {
		ResponseEntity<?> responseEntity;
		List<AccountStatement> list = customerService.fetchAccountStatement(account.getStartDate(),account.getEndDate());
		return responseEntity = new ResponseEntity<List<AccountStatement>>(list, HttpStatus.OK);
	}

}
