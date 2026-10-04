package com.proj.RailGati.run.entity;

import com.proj.RailGati.station.entity.StationEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(
        name = "train_positions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "idx_position_run_recorded",
                        columnNames = {"train_run_id", "recorded_date"}
                )
        }
)
public class TrainPositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_run_id", nullable = false)
    private TrainRunEntity trainRun;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "speed_kmph", precision = 6, scale = 2)
    private BigDecimal speedKmph;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_station_id")
    private StationEntity currentStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_station_id")
    private StationEntity nextStation;

    @Column(name = "recorded_at", nullable = false)
    private LocalDateTime recordedAt;
}
