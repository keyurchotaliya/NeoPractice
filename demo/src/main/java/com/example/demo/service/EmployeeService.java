package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	List<Employee> listAllEmployees();

	Optional<Employee> getEmployeeByID(Integer id);

	Employee save(Employee employee);

	void deleteEmployee(Integer id);
}
