package com.proj.RailGati.station.service;

import com.proj.RailGati.common.exception.ResourceNotFoundException;
import com.proj.RailGati.station.mapper.StationMapper;
import com.proj.RailGati.station.dto.StationResponseDTO;
import com.proj.RailGati.station.entity.StationEntity;
import com.proj.RailGati.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    @Override
    public StationResponseDTO getStationByCode(String code){
        StationEntity entity = stationRepository.findByCode(code)
                .orElseThrow(()->
                        new ResourceNotFoundException("Station not found with code: "+code));
        return StationMapper.toResponseDTO(entity);
    }
}
