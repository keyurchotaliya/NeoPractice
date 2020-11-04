package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Long> {

	Employee findByFirstName(String firstName);

}
