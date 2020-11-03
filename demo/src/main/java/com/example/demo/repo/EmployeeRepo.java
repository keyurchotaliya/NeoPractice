package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	Employee findByFirstName(String firstName);

}
