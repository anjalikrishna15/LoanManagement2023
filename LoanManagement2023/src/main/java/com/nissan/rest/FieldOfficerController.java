package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.entity.FieldOfficer;
import com.nissan.entity.Loan;
import com.nissan.service.IFieldOfficerService;

@RestController
@RequestMapping("/api")
public class FieldOfficerController {
	@Autowired
	private IFieldOfficerService officerService;

	@Autowired
	private APIResponse apiResponse;

	// list
	@GetMapping("/officers")
	public List<FieldOfficer> getOfficers() {
		return officerService.getOfficers();

	}

	// add officer
	@PostMapping("/officers")
	public ResponseEntity<APIResponse> addCertificate(@RequestBody FieldOfficer officer) {
		officerService.saveOfficer(officer);
		apiResponse.setData("officer added successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// list request
	@GetMapping("/officer/loanrequests")
	public List<Loan> getAllLoanRequest() {
		return officerService.getLoanRequests();
	}

	// update loan request
	@PutMapping("/officer/loanrequests")
	public ResponseEntity<APIResponse> addLoanRequest(@RequestBody Loan loan) {

		if (officerService.saveLoanRequest(loan) == null) {
			apiResponse.setData("name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		apiResponse.setData("Loan Request updated successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
