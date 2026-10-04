package com.proj.RailGati.route.entity;

import com.proj.RailGati.line.entity.RailwayLineEntity;
import com.proj.RailGati.station.entity.StationEntity;
import com.proj.RailGati.train.entity.TrainEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "train_routes",
uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_train_route_seq",
                columnNames = {"train_id", "sequence_number"}
        ),
        @UniqueConstraint(
                name = "uk_train_route_stop",
                columnNames = {"train_id", "station_id"}
        )
})
public class TrainRouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_id", nullable = false)
    private TrainEntity train;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id")
    private RailwayLineEntity line;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "station_id", nullable = false)
    private StationEntity station;

    @Column(name = "sequence_number", nullable = false)
    private Integer sequenceNumber;

    @Column(name = "distance_from_origin_km", precision = 8, scale = 3)
    private BigDecimal distanceFromOriginKm;

    @Column(name = "is_origin")
    private Boolean origin;
}
