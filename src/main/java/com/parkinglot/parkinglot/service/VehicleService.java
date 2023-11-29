package com.parkinglot.parkinglot.service;

import com.parkinglot.parkinglot.dto.request.VehicleRequest;
import com.parkinglot.parkinglot.dto.response.VehicleResponse;
import com.parkinglot.parkinglot.entity.VehicleEntity;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<VehicleEntity> findAllVehicle();
    Optional<VehicleEntity> findById(Long id);
    VehicleEntity saveVehicle(VehicleEntity vehicleEntity);
    VehicleEntity updateVehicle(VehicleEntity vehicleEntity);
    void deleteVehicle(Long id);

    //    Using Request for Save and Update Vehicle
    VehicleResponse saveVehicle(VehicleRequest vehicleRequest);
    VehicleResponse updateVehicle(VehicleRequest vehicleRequest, Long id);


}