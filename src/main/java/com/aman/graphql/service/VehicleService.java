package com.aman.graphql.service;

import com.aman.graphql.entity.Vehicle;
import com.aman.graphql.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository ;

    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }

    @Transactional
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModel(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }

    @Transactional
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }

    @Transactional
    public List<Vehicle> getVehicleByModel(final String model) {
        return this.vehicleRepository.findByModel(model);
    }
}
