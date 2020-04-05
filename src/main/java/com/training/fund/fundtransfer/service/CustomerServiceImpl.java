package com.training.fund.fundtransfer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.training.fund.fundtransfer.constants.FundTransferConstants;
import com.training.fund.fundtransfer.entity.Account;
import com.training.fund.fundtransfer.entity.AccountStatement;
import com.training.fund.fundtransfer.entity.Customer;
import com.training.fund.fundtransfer.exception.AmountNotExistsException;
import com.training.fund.fundtransfer.model.CustomerRequest;
import com.training.fund.fundtransfer.model.Transfer;
import com.training.fund.fundtransfer.repository.AccountRepository;
import com.training.fund.fundtransfer.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public AccountRepository accountRepository;

	@Override
	public Customer registerCustomer(CustomerRequest customerRequest) {
		Customer customerEntity = mapCustomer(customerRequest);
		customerRepository.save(customerEntity);
		return customerEntity;
	}

	private Customer mapCustomer(CustomerRequest request) {
		Customer customer = null;
		if (request != null) {
			customer = new Customer();
			if (StringUtils.isNotBlank(request.getFname()))
				customer.setFname(request.getFname());
			if (StringUtils.isNotBlank(request.getLname()))
				customer.setLname(request.getLname());
			if (StringUtils.isNotBlank(request.getAadhar()))
				customer.setAadhar(request.getAadhar());
			if (StringUtils.isNotBlank(request.getPan()))
				customer.setPan(request.getPan());
			if (StringUtils.isNotBlank(request.getAddress()))
				customer.setAddress(request.getAddress());
			if (request.getAge() != null)
				customer.setAge(request.getAge());

			Account acc = null;
			AccountStatement statement = null;
			if (request.getAccountRequest() != null) {
				acc = new Account();
				List<AccountStatement> stmtList = new ArrayList<>();
				statement = new AccountStatement();
				if (StringUtils.isNotBlank(request.getAccountRequest().getBankName()))
					acc.setBankName(request.getAccountRequest().getBankName());
				if (StringUtils.isNotBlank(request.getAccountRequest().getAccountType()))
					acc.setAccountType(request.getAccountRequest().getAccountType());
				acc.setAccountNumber(randomNumber());
				acc.setBalance(FundTransferConstants.BALANCE);
				statement.setAccountAmt(FundTransferConstants.BALANCE);
				statement.setStatus(FundTransferConstants.STATUS_CREDITED);
				statement.setDate(new Date());
				statement.setAccount(acc);
				stmtList.add(statement);
				acc.setStatusAccount(stmtList);
				acc.setCustomer(customer);
			}
			customer.setAccount(acc);
		}

		return customer;
	}

	public static long randomNumber() {
		long s = 1000_0000_0000_0000L;
		long b = 9999_9999_9999_9999l;
		long randomValue = ThreadLocalRandom.current().nextLong(s, b + 1);
		System.out.println(randomValue);
		return randomValue;

	}

	@Override
	public Transfer transferAmount(Transfer transfer) {
		Optional<Account> custFromRes = accountRepository.findById(transfer.getFromCid());
		Optional<Account> custToRes = accountRepository.findById(transfer.getToCid());
		// List<Customer> listCust = customerRepository.findAll();
		Account fromRes = null;
		Account toRes = null;
		if (custFromRes.isPresent() && custToRes.isPresent()) {
			fromRes = custFromRes.get();
			toRes = custToRes.get();
			Integer fromAmt = fromRes.getBalance();

			if (fromAmt > 0 && fromAmt >= transfer.getAmount()) {
				Integer toAmt = toRes.getBalance();
				Integer faccId = fromRes.getAccountId();
				Integer taccId = toRes.getAccountId();
				toAmt = toAmt + transfer.getAmount();
				fromAmt = fromAmt - transfer.getAmount();
				fromRes.setBalance(fromAmt);
				fromRes.setAccountId(faccId);
				toRes.setAccountId(taccId);
				toRes.setBalance(toAmt);
				if(fromRes !=null) {
					List<AccountStatement> fromStatemet = fromRes.getStatusAccount();
					List<AccountStatement> fromList=mapFromAccountStatement(fromStatemet,transfer,fromRes);
					fromRes.setStatusAccount(fromList);
				}
				if(toRes !=null) {
					List<AccountStatement> toStatemet = toRes.getStatusAccount();
					List<AccountStatement> toList=mapToAccountStatement(toStatemet,transfer,toRes);
					toRes.setStatusAccount(toList);
				}
				accountRepository.save(fromRes);
				accountRepository.save(toRes);

			} else {

				throw new AmountNotExistsException();
			}

		}

		return transfer;

	}
	
	private List<AccountStatement> mapFromAccountStatement(List<AccountStatement> stmt,Transfer transfer,Account acc){
		AccountStatement accstmt=null;
		if(!CollectionUtils.isEmpty(stmt)) {
			accstmt=new AccountStatement();
			accstmt.setAccountAmt(transfer.getAmount());
			accstmt.setDate(new Date());
			accstmt.setStatus(FundTransferConstants.STATUS_DEPITED);
			accstmt.setAccount(acc);
			stmt.add(accstmt);
		}
		return stmt;
	}
	
	private List<AccountStatement> mapToAccountStatement(List<AccountStatement> stmt,Transfer transfer,Account acc){
		AccountStatement accstmt=null;
		if(!CollectionUtils.isEmpty(stmt)) {
			accstmt=new AccountStatement();
			accstmt.setAccountAmt(transfer.getAmount());
			accstmt.setDate(new Date());
			accstmt.setStatus(FundTransferConstants.STATUS_CREDITED);
			accstmt.setAccount(acc);
			stmt.add(accstmt);
		}
		return stmt;
	}


	@Override
	public List<Customer> fetchAllAccountDetails() {
		return customerRepository.findAll();
	}

	@Override
	public Customer fetchAccountDetails(Integer cid) {
		Customer customer = null;
		Optional<Customer> custRes = customerRepository.findById(cid);
		if (custRes.isPresent()) {
			customer = custRes.get();
		}
		return customer;
	}

}
