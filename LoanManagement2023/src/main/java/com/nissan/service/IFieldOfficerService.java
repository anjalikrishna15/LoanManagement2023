package com.nissan.service;

import java.util.List;

import com.nissan.entity.FieldOfficer;
import com.nissan.entity.Loan;

public interface IFieldOfficerService {

	// list
	public List<Loan> getLoanRequests();

	// insert
	public Loan saveLoanRequest(Loan loan);

	 public List<FieldOfficer> getOfficers();
	// insert
	 public FieldOfficer saveOfficer(FieldOfficer officer);
}
