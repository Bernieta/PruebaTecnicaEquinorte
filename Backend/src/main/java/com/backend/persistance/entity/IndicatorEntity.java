package com.backend.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de indicadores
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "indicators")
public class IndicatorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indicator_name", length = 55)
    private String indicatorName;

    @Column(name = "expected_value", nullable = false)
    private Double expectedValue;

    @Column(name = "max_value", nullable = false)
    private Double maxValue;

    @Column(name = "min_value", nullable = false)
    private Double minValue;

    @OneToMany(
            targetEntity = MeasurementEntity.class,
            mappedBy = "indicator",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<MeasurementEntity> measurements;

}
