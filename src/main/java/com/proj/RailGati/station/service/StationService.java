package com.proj.RailGati.station.service;

import com.proj.RailGati.station.dto.StationResponseDTO;

public interface StationService {
    StationResponseDTO getStationByCode(String code);
}
