package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Vehicle;
import com.example.demo.repo.VehicleRepo;
import com.example.demo.service.VehicleService;


@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepo vehicleRepo;

	@Override
	public List<Vehicle> listAllVehicles() {
		List<Vehicle> vehicleList = vehicleRepo.findAll();
		return vehicleList;
	}

	@Override
	public Optional<Vehicle> getVehicleByID(Integer id) {
		Optional<Vehicle> u = vehicleRepo.findById(id);
		return u;
	}

	@Override
	public Vehicle save(Vehicle vehicle) {

		vehicleRepo.save(vehicle);
		return vehicle;
	}

	@Override
	public void deleteVehicle(Integer id) {
		// Vehicle deleted = vehicleRepo.getOne(id);
		vehicleRepo.deleteById(id);
		return;

	}

	@Override
	public Vehicle Update(Integer id, Vehicle Vehicle) {
		Vehicle saved = vehicleRepo.getOne(id);

		saved.setVehicleRegNo(Vehicle.getVehicleRegNo());
		return saved;

	}

	@Override
	public Vehicle findByVehiclRegNo(String vehicleRegNo) {
		Vehicle found = vehicleRepo.findByVehicleRegNo(vehicleRegNo);
		return found;
	}

}
