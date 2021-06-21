package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Vehicle;

public interface VehicleService {

	List<Vehicle> listAllVehicles();

	Optional<Vehicle> getVehicleByID(Integer id);

	Vehicle save(Vehicle vehicle);

	void deleteVehicle(Integer id);

	Vehicle Update(Integer id, Vehicle Vehicle);

	Vehicle findByVehiclRegNo(String vehicleRegNo);
}
