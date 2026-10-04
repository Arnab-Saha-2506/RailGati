package com.proj.RailGati.run.entity;

import com.proj.RailGati.train.entity.TrainEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(
        name = "train_runs",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_train_run_date",
                        columnNames = {"train_id", "run_date"}
                )
        }
)
public class TrainRunEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "train_id", nullable = false)
    private TrainEntity train;

    @Column(name = "run_date", nullable = false)
    private LocalDate runDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private TrainRunStatus status = TrainRunStatus.SCHEDULED;

    @Column(name = "delay_minutes")
    private Integer delayMinutes;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @OneToMany(mappedBy = "trainRun", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TrainPositionEntity> positions = new ArrayList<>();

    public boolean isDelayed(){
        return delayMinutes != null && delayMinutes > 0;
    }
}
