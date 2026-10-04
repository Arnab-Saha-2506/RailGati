package com.proj.RailGati.train.repository;

import com.proj.RailGati.train.entity.TrainEntity;
import com.proj.RailGati.train.entity.TrainType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<TrainEntity, Long> {
    Optional<TrainEntity> findByTrainNumber(String trainNumber);
    List<TrainEntity> findByActiveTrueOrderByTrainNumberAsc();
    List<TrainEntity> findByTrainTypeAndActiveTrue(TrainType trainType);
}
