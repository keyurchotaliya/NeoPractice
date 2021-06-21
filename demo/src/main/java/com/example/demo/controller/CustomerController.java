package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RequestMapping("/agsapi")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired(required=true)
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	@PostMapping("/user")
	public Customer createCustomer(@RequestBody Customer customer) throws Exception {
		
		Customer customer1 = customerService.save(customer);
		return customer1;
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteCustomer(@PathVariable Integer id) throws Exception {
		
		customerService.deleteCustomer(id);
	}
	
	@PutMapping("/user/{id}")
	public Customer editCustomer(@PathVariable Integer id,@RequestBody Customer customer) throws Exception {
		
		Customer customer1 = customerService.Update(id, customer);
		return customer1;
	}
	
	@GetMapping("/load")
	public org.springframework.batch.core.BatchStatus load() throws JobParametersInvalidException, Exception {
		
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		JobParameters jobParameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		System.out.println("JobExecution "+ jobExecution.getStatus());
		
		System.out.println("Batch is running");
		while(jobExecution.isRunning()) {
			System.out.println("...");
		}
		return jobExecution.getStatus();
	}
	

}
