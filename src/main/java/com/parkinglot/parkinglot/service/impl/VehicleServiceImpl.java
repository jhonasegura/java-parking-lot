package com.developer.parkinglot.service.impl;

import com.developer.parkinglot.dto.mapper.VehicleMapper;
import com.developer.parkinglot.dto.request.VehicleRequest;
import com.developer.parkinglot.dto.response.VehicleResponse;
import com.developer.parkinglot.entity.VehicleEntity;
import com.developer.parkinglot.repository.VehicleRepository;
import com.developer.parkinglot.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleEntity> findAllVehicle() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<VehicleEntity> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public VehicleEntity saveVehicle(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

    @Override
    public VehicleEntity updateVehicle(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

//    Using Request and Response with save and update vehicle

    @Override
    public VehicleResponse saveVehicle(VehicleRequest vehicleRequest) {
        VehicleEntity vehicleEntity = VehicleMapper.MAPPER.fromRequestToEntity(vehicleRequest);
        vehicleRepository.save(vehicleEntity);
        return VehicleMapper.MAPPER.fromEntityToResponse(vehicleEntity);
    }

    @Override
    public VehicleResponse updateVehicle(VehicleRequest vehicleRequest, Long id) {

        Optional<VehicleEntity> checkExistingVehicle = findById(id);
        if (! checkExistingVehicle.isPresent())
            throw new RuntimeException("Vehicle Id "+ id + " Not Found!");

        VehicleEntity vehicleEntity = VehicleMapper.MAPPER.fromRequestToEntity(vehicleRequest);
        vehicleEntity.setId(id);
        vehicleRepository.save(vehicleEntity);
        return VehicleMapper.MAPPER.fromEntityToResponse(vehicleEntity);
    }

}

