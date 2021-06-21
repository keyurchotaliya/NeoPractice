package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	@Override
	public List<Customer> listAllCustomers() {
		List<Customer> CustomerList = customerRepo.findAll();
		return CustomerList;
	}

	@Override
	public Optional<Customer> getCustomerByID(Integer id) {
		Optional<Customer> r = customerRepo.findById(id);
		return r;
	}

	@Override
	public Customer save(Customer Customer) {
		customerRepo.save(Customer);
		return Customer;
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerRepo.deleteById(id);
		return;
	}

	@Override
	public Customer Update(Integer id, Customer customer) {
		Customer saved = customerRepo.getOne(id);

		saved.setFirstName(customer.getFirstName());
		saved.setSurName(customer.getFirstName());
		saved.setEmail(customer.getEmail());
		return saved;

	}

	public CustomerPagedList CustomerPagedList(Customer customer, PageRequest pageRequest) {

		CustomerPagedList customerPagedList;
		Page<Customer> customerPage;
		
		
		
			customerPage = customerRepo.findAll(pageRequest);
		
		customerPagedList = new CustomerPagedList(customerPage.getContent().stream().collect(Collectors.toList()),
				PageRequest.of(customerPage.getPageable().getPageNumber(), customerPage.getPageable().getPageSize()),
				customerPage.getTotalElements());

		return customerPagedList;
	}
}
