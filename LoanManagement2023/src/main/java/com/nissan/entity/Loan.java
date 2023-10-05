package com.nissan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loan {
	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loanId")
	private Integer loanId;
	// loan name
	@Column(name = "loanType", nullable = false, length = 60)
	private String loanType;

	// customer id
	@Column(name = "customerId")
	private Integer customerId;
	@ManyToOne
	@JoinColumn(name = "customerId", insertable = false, updatable = false)
	private Customer customer;

	// field offcier Id
	@Column(name = "officerId")
	private Integer officerId;
	@ManyToOne
	@JoinColumn(name = "officerId", insertable = false, updatable = false)
	private FieldOfficer officer;

	// status

	@Column(name = "status")
	private String status;

	// background verification

	@Column(name = "bgVerification")
	private String bgVerification;

	// loan amount
	@Column(name = "loanAmount")
	private Integer loanAmount;

	// is active
	private boolean isActive = true;

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getOfficerId() {
		return officerId;
	}

	public void setOfficerId(Integer officerId) {
		this.officerId = officerId;
	}

	public FieldOfficer getOfficer() {
		return officer;
	}

	public void setOfficer(FieldOfficer officer) {
		this.officer = officer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBgVerification() {
		return bgVerification;
	}

	public void setBgVerification(String bgVerification) {
		this.bgVerification = bgVerification;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
