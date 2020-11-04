package com.example.demo.model.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customExceptions.ResourceNotFoundException;
import com.example.demo.domain.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.SequenceGeneratorService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired(required = true)
	EmployeeRepo employeeRepo;

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;

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
		employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		employeeRepo.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
		return;

	}

	@Override
	public Employee findByFirstName(String firstName) {
		Employee found = employeeRepo.findByFirstName(firstName);
		return found;
	}

	@Override
	public Employee Update(Long employeeId, Employee employee) throws ResourceNotFoundException {
		Employee saved = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		saved.setEmailId(employee.getEmailId());
		saved.setLastName(employee.getLastName());
		saved.setFirstName(employee.getFirstName());
		final Employee updatedEmployee = employeeRepo.save(employee);
		return updatedEmployee;
	}

}
