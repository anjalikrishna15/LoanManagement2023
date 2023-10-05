package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.entity.Customer;
import com.nissan.entity.Loan;
import com.nissan.repository.IAdminRepository;
import com.nissan.repository.ICustomerRepository;

@Transactional
@Service

public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;
	@Autowired
	private IAdminRepository adminRepo;
	

	@Autowired
	private Validation validation;

	@Override
	public List<Loan> getLoanRequests() {
		// TODO Auto-generated method stub
		return (List<Loan>) adminRepo.findAll();
	}

	@Override
	public Loan saveLoanRequest(Loan loan) {
		if (loan.getLoanType()!=null) {
			return adminRepo.save(loan);
		}
		return null;
	}

	

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>) customerRepo.findAll();
	}

	public Customer saveCustomer(Customer customer) {
		if(validation.isNameValid(customer.getCustomerName())) {
			return customerRepo.save(customer) ;
		}
		return null ;
	}

}
