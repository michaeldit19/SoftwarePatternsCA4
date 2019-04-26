package com.example.demo.service;

import com.example.demo.model.Customers;
import com.example.demo.model.Login;

public interface CustomerService {
	
	Customers validateCustomer(Login login);
	
	void register(Customers customers);
	
	void updateCustomer(int id, Customers c);
	
	Customers getCustomerById(int id);

}
