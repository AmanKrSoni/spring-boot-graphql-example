package com.aman.graphql.query;

import com.aman.graphql.entity.Vehicle;
import com.aman.graphql.service.VehicleService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {
    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }

    public List<Vehicle> getVehiclesByModel(final String model) {
        return this.vehicleService.getVehicleByModel(model);
    }


}
