package com.nissan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nissan.entity.Loan;
@Service
public interface IAdminService {

	// list
	public List<Loan> getLoanRequests();

	// insert
	public Loan saveLoanRequest(Loan loan);

}
