package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Employee;


public interface EmployeeService {

	List<Employee> listAllEmployees();

	Optional<Employee> getEmployeeByID(Long id);

	Employee save(Employee employee);

	Employee Update(Long Id,Employee employee);

	void deleteEmployee(Long id);
	
	Employee findByFirstName(String firstame);

}
