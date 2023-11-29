package com.developer.parkinglot.controller;

import com.developer.parkinglot.dto.request.VehicleRequest;
import com.developer.parkinglot.dto.response.VehicleResponse;
import com.developer.parkinglot.entity.VehicleEntity;
import com.developer.parkinglot.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleEntity> findAllVehicle() {
        return vehicleService.findAllVehicle();
    }

    @GetMapping("/{id}")
    public Optional<VehicleEntity> findVehicleById(@PathVariable("id") Long id) {
        return vehicleService.findById(id);
    }

    @PostMapping
    public VehicleEntity saveVehicle(@RequestBody VehicleEntity vehicleEntity) {
        return vehicleService.saveVehicle(vehicleEntity);
    }

    @PutMapping("/{id}")
    public VehicleEntity updateVehicle(@RequestBody VehicleEntity vehicleEntity) {
        return vehicleService.updateVehicle(vehicleEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteVehicle(id);
    }

}
