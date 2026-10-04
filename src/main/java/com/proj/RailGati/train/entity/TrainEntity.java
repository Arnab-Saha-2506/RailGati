package com.proj.RailGati.train.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "trains")
public class TrainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String trainNumber;

    @Column(nullable = false)
    private String trainName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TrainType type;

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = Boolean.TRUE;

    @Column(nullable = false, length = 3)
    private String sourceDivision;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TrainRouteEntity> routes = new ArrayList<>();
}
