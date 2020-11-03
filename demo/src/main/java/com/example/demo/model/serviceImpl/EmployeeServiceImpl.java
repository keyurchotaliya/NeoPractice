package com.example.demo.model.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public List<Employee> listAllEmployees() {
		List<Employee> userList = employeeRepo.findAll();
		return userList;

	}

	@Override
	public Optional<Employee> getEmployeeByID(Long id) {
		Optional<Employee> u = employeeRepo.findById(id);
		return u;
	}

	@Override
	public Employee save(Employee employee) {

		employeeRepo.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		return;

	}

	@Override
	public Employee Update(Long id, Employee employee) {
		Employee saved = employeeRepo.getOne(id);
		saved.setFirstName(employee.getFirstName());
		saved.setLastName(employee.getLastName());
		saved.setEmailId(employee.getEmailId());
		employeeRepo.save(saved);
		return saved;

	}

	@Override
	public Employee findByFirstName(String firstName) {
		Employee found = employeeRepo.findByFirstName(firstName);
		return found;
	}

}
