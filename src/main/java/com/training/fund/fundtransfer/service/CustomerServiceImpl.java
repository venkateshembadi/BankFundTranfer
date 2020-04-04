package com.training.fund.fundtransfer.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.fund.fundtransfer.constants.FundTransferConstants;
import com.training.fund.fundtransfer.entity.Account;
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
			if (StringUtils.isNotBlank(request.getAdhar()))
				customer.setAadhar(request.getAdhar());
			if (StringUtils.isNotBlank(request.getPan()))
				customer.setPan(request.getPan());
			if (StringUtils.isNotBlank(request.getAddress()))
				customer.setAddress(request.getAddress());
			if (request.getAge() != null)
				customer.setAge(request.getAge());

			Account acc = null;
			if (request.getAccountRequest() != null) {
				acc = new Account();
				if (StringUtils.isNotBlank(request.getAccountRequest().getBankName()))
					acc.setBankName(request.getAccountRequest().getBankName());
				if (StringUtils.isNotBlank(request.getAccountRequest().getAccountType()))
					acc.setAccountType(request.getAccountRequest().getAccountType());
				acc.setAccountNumber(randomNumber());
				acc.setBalance(FundTransferConstants.BALANCE);
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

			if (fromAmt > 0 && fromAmt > transfer.getAmount()) {
				Integer toAmt = toRes.getBalance();
				Integer faccId = fromRes.getAccountId();
				Integer taccId = toRes.getAccountId();
				toAmt = toAmt + transfer.getAmount();
				fromAmt = fromAmt - transfer.getAmount();
				fromRes.setBalance(fromAmt);
				fromRes.setAccountId(faccId);
				toRes.setAccountId(taccId);
				toRes.setBalance(toAmt);
				accountRepository.save(fromRes);
				accountRepository.save(toRes);

			} else {

				throw new AmountNotExistsException();
			}

		}

		return transfer;

	}

	@Override
	public List<Customer> fetchAllAccountDetails() {
		return customerRepository.findAll();
	}

}
