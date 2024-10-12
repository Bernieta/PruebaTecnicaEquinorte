package com.backend.service.interfaces;

import com.backend.presentation.dto.MeasurementRequestDTO;
import com.backend.presentation.dto.MeasurementIndicatorResponseDTO;
import com.backend.presentation.dto.MeasurementResponseDTO;

import java.util.List;

public interface MeasurementService {

    /**
     * Obtiene una lista de medidas de un indicador
     *
     * @param id El identificador del indicador del que se desean obtener las medidad
     * @return Una lista de medidas del indicador especificado
     */
    List<MeasurementIndicatorResponseDTO> findMeasurementsWithStatusByIndicatorId(Long id);

    /**
     * Crea una nueva medida para un indicador
     *
     * @param measurementRequestDTO DTO con los datos de la medida
     * @return La medida creada
     */
    MeasurementResponseDTO createMeasurement(MeasurementRequestDTO measurementRequestDTO);

}
