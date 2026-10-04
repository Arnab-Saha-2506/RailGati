package com.proj.RailGati.schedule.entity;

import com.proj.RailGati.route.entity.TrainRouteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "train_schedule",
uniqueConstraints =
@UniqueConstraint(name="uk_schedule_route", columnNames = "train_route_id"))
public class TrainScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_route_id", nullable = false)
    private TrainRouteEntity route;

    @Column(name = "scheduled_arrival")
    private LocalTime scheduledArrival;

    @Column(name = "scheduled_departure")
    private LocalTime scheduledDeparture;

    /**
     * 0 = same calendar day as the run date, 1 = next day.
     * Needed for trains whose journey crosses midnight (e.g. 00:30 arrival).
     */
    @Column(name = "day_offset")
    @Builder.Default
    private Integer dayOffset = 0;

    @Column(name = "halt_minutes")
    private Integer haltMinutes;

    @Column(name = "platform_number")
    private Integer platformNumber;
}
