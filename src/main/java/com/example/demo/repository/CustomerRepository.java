package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customers;

public interface CustomerRepository extends CrudRepository<Customers, Integer> {
	
	

}
