package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Vehicle;

public interface CustomerService {

	List<Customer> listAllCustomers();

	Optional<Customer> getCustomerByID(Integer id);

	Customer save(Customer customer);

	void deleteCustomer(Integer id);

	Customer Update(Integer id, Customer customer);


}
