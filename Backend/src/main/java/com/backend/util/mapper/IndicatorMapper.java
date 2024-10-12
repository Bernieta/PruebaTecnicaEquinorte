package com.backend.util.mapper;

import com.backend.persistance.entity.IndicatorEntity;
import com.backend.presentation.dto.IndicatorRequestDTO;
import com.backend.presentation.dto.IndicatorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IndicatorMapper {

    /**
     * Convierte un objeto IndicatorRequestDTO a un objeto IndicatorEntity.
     * Se ignoran los campos "measurements" e "id" durante la conversión.
     *
     * @param indicatorRequestDTO El objeto de solicitud que contiene los datos del indicador a convertir.
     * @return Un objeto IndicatorEntity.
     */
    @Mapping(target = "measurements", ignore = true)
    @Mapping(target = "id", ignore = true)
    IndicatorEntity toIndicatorEntity(IndicatorRequestDTO indicatorRequestDTO);

    /**
     * Convierte un objeto IndicatorEntity a un objeto IndicatorResponseDTO.
     *
     * @param indicatorEntity El objeto de entidad que contiene los datos del indicador a convertir.
     * @return Un objeto IndicatorResponseDTO.
     */
    IndicatorResponseDTO toIndicatorResponseDto(IndicatorEntity indicatorEntity);

    /**
     * Convierte una lista de objetos IndicatorEntity a una lista de objetos IndicatorResponseDTO.
     *
     * @param indicatorEntityList La lista de entidades de indicador que se van a convertir.
     * @return Una lista de objetos IndicatorResponseDTO.
     */
    List<IndicatorResponseDTO> toIndicatorResponseDtoList(List<IndicatorEntity> indicatorEntityList);

}
