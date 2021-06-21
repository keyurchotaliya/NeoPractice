package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Vehicle;


@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {

	Vehicle findByVehicleRegNo(String vehicleRegNo);

	
}