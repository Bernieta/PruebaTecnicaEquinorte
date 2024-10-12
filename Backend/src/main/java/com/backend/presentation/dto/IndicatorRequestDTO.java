package com.backend.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para crear y actualizar un indicador
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IndicatorRequestDTO {

    private String indicatorName;
    private Double expectedValue;
    private Double maxValue;
    private Double minValue;

}
