package com.backend.util.mapper;

import com.backend.persistance.entity.MeasurementEntity;
import com.backend.presentation.dto.MeasurementRequestDTO;
import com.backend.presentation.dto.MeasurementResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapeador de medidas
 */
@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    /**
     * Convierte un objeto MeasurementRequestDTO a un objeto MeasurementEntity.
     * Se ignoran los campos "id" e "indicator" durante la conversión.
     *
     * @param measurementRequestDTO El objeto de solicitud que contiene los datos de la medición a convertir.
     * @return Un objeto MeasurementEntity.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "indicator", ignore = true)
    MeasurementEntity toMeasurementEntity(MeasurementRequestDTO measurementRequestDTO);

    /**
     * Convierte un objeto MeasurementEntity a un objeto MeasurementResponseDTO.
     *
     * @param measurementEntity El objeto de entidad que contiene los datos de la medición a convertir.
     * @return Un objeto MeasurementResponseDTO.
     */
    MeasurementResponseDTO toMeasurementResponseDto(MeasurementEntity measurementEntity);

}
