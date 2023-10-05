package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.entity.Loan;
import com.nissan.repository.IAdminRepository;
@Service
public class AdminServiceImplementation implements IAdminService{
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
		if(loan.getLoanType()!=null) {
			return adminRepo.save(loan) ;
		}
		return null ;
	}

}
