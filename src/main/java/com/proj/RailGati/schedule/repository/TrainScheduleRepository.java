package com.proj.RailGati.schedule.repository;

import com.proj.RailGati.schedule.entity.TrainScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainScheduleRepository extends JpaRepository<TrainScheduleEntity, Long> {

    @Query("""
           select s from TrainScheduleEntity s
           join fetch s.route r
           join fetch r.station
           where r.train.id = :trainId
           order by r.sequenceNumber asc
           """
    )
    List<TrainScheduleEntity> findByTrainId(
            @Param("trainId") Long trainId
    );

    @Query("""
           select s from TrainScheduleEntity s
           join fetch s.route r
           join fetch r.station
           where r.train.trainNumber = :trainNumber
           order by r.sequenceNumber asc
           """
    )
    List<TrainScheduleEntity> findByTrainNumber(
            @Param("trainNumber") String trainNumber
    );
}
