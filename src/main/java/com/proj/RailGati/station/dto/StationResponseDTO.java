package com.proj.RailGati.station.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationResponseDTO{
    Long id;
    String code;
    String name;
    BigDecimal latitude;
    BigDecimal longitude;
}
