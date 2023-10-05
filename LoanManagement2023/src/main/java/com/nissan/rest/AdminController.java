package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.entity.Customer;
import com.nissan.entity.Loan;
import com.nissan.service.IAdminService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	@Autowired
	private APIResponse apiResponse;

	// list
	@GetMapping("/admin/loanrequests")
	public List<Loan> getAllLoanRequest() {
		return adminService.getLoanRequests();

	}

	// update loan request
	@PutMapping("/admin/loanrequests")
	public ResponseEntity<APIResponse> updateLoan(@RequestBody Loan loan) {
		if (adminService.saveLoanRequest(loan) == null) {
			apiResponse.setData("name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		apiResponse.setData("Loan request updated successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
