package com.kvvinay.service;

import java.util.List;

import com.kvvinay.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomerr();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
