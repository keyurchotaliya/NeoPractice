package com.example.demo.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.demo.entity.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Customer")
@AllArgsConstructor
@Getter
@Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String surName;
	private String title;
	private String email;
	private long mobileNo1;
	
	
	@OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id", referencedColumnName = "id") // we need to duplicate the physical information
    private List<Vehicle> Vehicles;
	
}
