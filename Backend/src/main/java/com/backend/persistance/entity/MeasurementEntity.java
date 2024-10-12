package com.backend.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Entidad de medidas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "measurements")
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "indicator_id")
    private Long indicatorId;

    private String description;

    @Column(name = "measurement_date", nullable = false)
    private LocalDate measurementDate;

    @Column(name = "measurement_value", nullable = false)
    private Double measurementValue;

    @ManyToOne(targetEntity = IndicatorEntity.class)
    @JoinColumn(name = "indicator_id", referencedColumnName = "id", insertable = false, updatable = false)
    private IndicatorEntity indicator;
}
