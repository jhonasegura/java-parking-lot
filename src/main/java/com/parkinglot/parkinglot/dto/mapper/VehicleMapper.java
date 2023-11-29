package com.parkinglot.parkinglot.dto.mapper;

import com.parkinglot.parkinglot.dto.request.VehicleRequest;
import com.parkinglot.parkinglot.dto.response.VehicleResponse;
import com.parkinglot.parkinglot.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper MAPPER = Mappers.getMapper(VehicleMapper.class);
    VehicleEntity fromRequestToEntity(VehicleRequest vehicleRequest);
    VehicleResponse fromEntityToResponse(VehicleEntity vehicleEntity);
}