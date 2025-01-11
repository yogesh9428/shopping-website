package com.Shopping.service;

import java.util.List;

import com.Shopping.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

}
