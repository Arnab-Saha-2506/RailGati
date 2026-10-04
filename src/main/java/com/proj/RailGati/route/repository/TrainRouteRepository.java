package com.proj.RailGati.route.repository;

import com.proj.RailGati.route.entity.TrainRouteEntity;
import com.proj.RailGati.train.entity.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainRouteRepository extends JpaRepository<TrainRouteEntity, Long> {

    List<TrainRouteEntity> findByTrainIdOrderBySequenceNumberAsc(Long trainId);

    Optional<TrainRouteEntity> findByTrainIdAndSequenceNumber(Long trainId, Integer sequenceNumber);

    Optional<TrainRouteEntity> findByTrainIdAndStationId(Long trainId, Long stationId);

    @Query("""
            select r from TrainRouteEntity r
            join fetch r.station
            where r.train.id = :trainId and r.sequenceNumber > :sequenceNumber
            order by r.sequenceNumber asc
            """
    )
    List<TrainRouteEntity> findUpcomingStops(
            @Param("trainId") Long trainId,
            @Param("sequenceNumber") Integer sequenceNumber
    );
}
