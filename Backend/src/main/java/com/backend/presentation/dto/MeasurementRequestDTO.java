package com.backend.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO para crear una medicion de un indicador
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeasurementRequestDTO {

    private Long indicatorId;
    private String description;
    private LocalDate measurementDate;
    private Double measurementValue;

}
