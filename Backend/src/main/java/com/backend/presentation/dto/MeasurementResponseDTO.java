package com.backend.presentation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO para respuestas de la creacion de medidas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MeasurementResponseDTO {

    private Long id;
    private Long indicatorId;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate measurementDate;
    private Double measurementValue;

}
