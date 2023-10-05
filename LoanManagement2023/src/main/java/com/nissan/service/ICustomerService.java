package com.nissan.service;

import java.util.List;

import com.nissan.entity.Customer;
import com.nissan.entity.Loan;

public interface ICustomerService {

	// list
	public List<Loan> getLoanRequests();

	// insert
	public Loan saveLoanRequest(Loan loan);

//	// list
	public List<Customer> getCustomers();
//
//	// insert
	public Customer saveCustomer(Customer customer);

}
