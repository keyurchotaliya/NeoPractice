package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeePagedList;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	EmployeeRepo empleyeeRepo;

	@Override
	public Optional<Employee> getEmployeeByID(Integer id) {
		Optional<Employee> r = empleyeeRepo.findById(id);
		return r;
	}

	@Override
	public Employee save(Employee Employee) {
		empleyeeRepo.save(Employee);
		return Employee;
	}

	@Override
	public void deleteEmployee(Integer id) {
		empleyeeRepo.deleteById(id);
		return;
	}

	@Override
	public List<Employee> listAllEmployees() {
		// TODO Auto-generated method stub
		return empleyeeRepo.findAll();
	}
	


	
}
