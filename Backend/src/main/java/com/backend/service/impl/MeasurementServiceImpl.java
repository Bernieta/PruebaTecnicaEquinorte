package com.backend.service.impl;

import com.backend.persistance.repository.MeasurementRepository;
import com.backend.presentation.dto.MeasurementRequestDTO;
import com.backend.presentation.dto.MeasurementIndicatorResponseDTO;
import com.backend.presentation.dto.MeasurementResponseDTO;
import com.backend.service.interfaces.MeasurementService;
import com.backend.util.mapper.MeasurementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de medidad
 */
@RequiredArgsConstructor
@Service
public class MeasurementServiceImpl implements MeasurementService {

    /**
     * Repositorio de medidas
     */
    private final MeasurementRepository measurementRepository;

    /**
     * Mapeador de medidas
     */
    private final MeasurementMapper measurementMapper;

    /**
     * Obtiene una lista de medidas de un indicador
     *
     * @param id El identificador del indicador del que se desean obtener las medidad
     * @return Una lista de medidas del indicador especificado
     */
    @Override
    public List<MeasurementIndicatorResponseDTO> findMeasurementsWithStatusByIndicatorId(Long id) {
        return measurementRepository.findMeasurementsWithStatusByIndicatorId(id);
    }

    /**
     * Crea una nueva medida para un indicador
     *
     * @param measurementRequestDTO DTO con los datos de la medida
     * @return La medida creada
     */
    @Override
    public MeasurementResponseDTO createMeasurement(MeasurementRequestDTO measurementRequestDTO) {
        return measurementMapper.toMeasurementResponseDto(
                measurementRepository.save(
                        measurementMapper.toMeasurementEntity(measurementRequestDTO)
                )
        );
    }
}
