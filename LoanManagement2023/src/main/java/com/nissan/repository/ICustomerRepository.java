package com.nissan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Customer;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

}
