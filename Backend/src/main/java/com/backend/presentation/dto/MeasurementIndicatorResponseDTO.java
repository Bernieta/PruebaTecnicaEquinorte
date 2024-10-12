package com.backend.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO para dar respuesta a las mediciones de los indicadores
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeasurementIndicatorResponseDTO {

    private String indicatorName;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate measurementDate;
    private Double measurementValue;
    private String status;

}
