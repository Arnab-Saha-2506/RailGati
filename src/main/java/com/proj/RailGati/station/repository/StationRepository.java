package com.proj.RailGati.station.repository;

import com.proj.RailGati.station.entity.StationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Long> {
    Optional<StationEntity> findByCode(String code);
}
