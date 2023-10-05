package com.nissan.repository;

import org.springframework.data.repository.CrudRepository;

import com.nissan.entity.Loan;

public interface IAdminRepository extends  CrudRepository<Loan, Integer> {

}
