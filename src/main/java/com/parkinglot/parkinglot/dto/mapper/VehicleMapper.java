package com.developer.parkinglot.dto.mapper;

import com.developer.parkinglot.dto.request.VehicleRequest;
import com.developer.parkinglot.dto.response.VehicleResponse;
import com.developer.parkinglot.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {
    VehicleMapper MAPPER = Mappers.getMapper(VehicleMapper.class);
    VehicleEntity fromRequestToEntity(VehicleRequest vehicleRequest);
    VehicleResponse fromEntityToResponse(VehicleEntity vehicleEntity);
}