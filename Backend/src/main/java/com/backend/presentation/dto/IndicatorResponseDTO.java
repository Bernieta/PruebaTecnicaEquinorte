package com.backend.presentation.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para dar respuesta a un indicador
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IndicatorResponseDTO {

    private Long id;
    private String indicatorName;
    private Double expectedValue;
    private Double maxValue;
    private Double minValue;

}
