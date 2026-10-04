package com.proj.RailGati.station.controller;

import com.proj.RailGati.station.dto.StationResponseDTO;
import com.proj.RailGati.station.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stations")
public class StationController {

    private final StationService stationService;

    @GetMapping("/{code}")
    public ResponseEntity<StationResponseDTO> getStationByCode(@PathVariable String code){
        StationResponseDTO response = stationService.getStationByCode(code);
        return ResponseEntity.ok().body(response);
    }
}
