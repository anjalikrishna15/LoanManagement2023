package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.entity.FieldOfficer;
import com.nissan.entity.Loan;
import com.nissan.repository.IAdminRepository;
import com.nissan.repository.IFieldOfficerRepository;

@Service
public class FieldOfficerServiceImple implements IFieldOfficerService {
	@Autowired
	private IFieldOfficerRepository officerRepo;
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

	public List<FieldOfficer> getOfficers() {
		// TODO Auto-generated method stub
		return (List<FieldOfficer>) officerRepo.findAll();
	}

	@Override
	public FieldOfficer saveOfficer(FieldOfficer officer) {
		if (validation.isNameValid(officer.getOfficerName())) {
			return officerRepo.save(officer);
		}
		return null;
	}
}
