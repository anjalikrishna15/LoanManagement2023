package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.entity.Customer;
import com.nissan.entity.Loan;
import com.nissan.service.ICustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	

	@Autowired
	private APIResponse apiResponse;

	// list request
	@GetMapping("/customer/loanrequests")
	public List<Loan> getAllLoanRequest() {
		return customerService.getLoanRequests();

	}

	// add loan request
	@PostMapping("/customer/loanrequests")
	public ResponseEntity<APIResponse> addLoanRequest(@RequestBody Loan loan) {

		if (customerService.saveLoanRequest(loan) == null) {
			apiResponse.setData("name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		apiResponse.setData("Loan Request added successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// list

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();

	}

	// add customer
	@PostMapping("/customers")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer) {

		if (customerService.saveCustomer(customer) == null) {
			apiResponse.setData("name can have only alphabets!");
			apiResponse.setStatus(500);
			apiResponse.setError("INVALID NAME");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}

		apiResponse.setData("Customer added successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
