package com.proj.RailGati.run.repository;

import com.proj.RailGati.run.entity.TrainPositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainPositionRepository extends JpaRepository<TrainPositionEntity, Long> {
    List<TrainPositionEntity> findByTrainRunIdOrderByRecordedAtAsc(Long trainRunId);
    Optional<TrainPositionEntity> findFirstByTrainRunIdOrderByRecordedAtDesc(Long trainRunId);

    List<TrainPositionEntity> findByTrainRunIdAndRecordedAtAfterOrderByRecordedAtAsc(Long trainRunId, LocalDateTime recordedAt);

    void deleteByTrainRunId(Long trainRunId);
}
