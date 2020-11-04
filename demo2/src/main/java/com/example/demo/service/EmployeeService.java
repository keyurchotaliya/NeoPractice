package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.customExceptions.ResourceNotFoundException;
import com.example.demo.domain.Employee;

public interface EmployeeService {

	List<Employee> listAllEmployees();

	Optional<Employee> getEmployeeByID(Long id);

	Employee save(Employee employee);

	void deleteEmployee(Long id);

	Employee findByFirstName(String firstame);

	Employee Update(Long id, Employee employee) throws ResourceNotFoundException;

}
