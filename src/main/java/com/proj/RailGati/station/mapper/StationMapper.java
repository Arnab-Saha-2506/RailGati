package com.proj.RailGati.station.mapper;

import com.proj.RailGati.station.dto.StationResponseDTO;
import com.proj.RailGati.station.entity.StationEntity;

public class StationMapper {
    public static StationResponseDTO toResponseDTO(StationEntity entity){
        return StationResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}
