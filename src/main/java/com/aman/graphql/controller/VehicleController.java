package com.aman.graphql.controller;

import com.aman.graphql.entity.Vehicle;
import com.aman.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("{id}")
    public ResponseEntity getVehicleById(@PathVariable("id") int id){
        return ResponseEntity.ok(service.getVehicle(id));
    }

    @PostMapping
    public ResponseEntity saveVehicle(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(service.createVehicle(vehicle.getType(), vehicle.getModel(), vehicle.getBrandName(), vehicle.getFormattedDate()));
    }

}
