package com.proj.RailGati.run.repository;

import com.proj.RailGati.run.entity.TrainRunEntity;
import com.proj.RailGati.run.entity.TrainRunStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainRunRepository extends JpaRepository<TrainRunEntity, Long> {
    Optional<TrainRunEntity> findByTrainIdAndRunDate(Long trainId, LocalDate runDate);
    Optional<TrainRunEntity> findByTrainTrainNumberAndRunDate(String trainNumber, LocalDate runDate);

    List<TrainRunEntity> findByRunDateAndStatusIn(LocalDate runDate, List<TrainRunStatus> statuses);

    List<TrainRunEntity> findByRunDateOrderByTrainTrainNumberAsc(LocalDate runDate);

    boolean existsByTrainIdAndRunDate(Long trainId, LocalDate runDate);
}
