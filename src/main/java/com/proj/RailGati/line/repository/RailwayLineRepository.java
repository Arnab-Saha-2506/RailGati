package com.proj.RailGati.line.repository;

import com.proj.RailGati.line.entity.RailwayLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RailwayLineRepository extends JpaRepository<RailwayLineEntity, Long> {
    Optional<RailwayLineEntity> findByCode(String code);

    List<RailwayLineEntity> findByZone(String zone);

    boolean existsByCode(String code);
}
