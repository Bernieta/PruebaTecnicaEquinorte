package com.backend.service.interfaces;

import com.backend.presentation.dto.IndicatorRequestDTO;
import com.backend.presentation.dto.IndicatorResponseDTO;

import java.util.List;
import java.util.Optional;

public interface IndicatorService {

    /**
     * Obtiene todos los indicadores registrados
     *
     * @return Un List con todos los indicadores
     */
    List<IndicatorResponseDTO> findAll();

    /**
     * Obtiene un indicador
     *
     * @param id Id del indicador a obtener
     * @return Un Optional del indicador obtenido
     */
    Optional<IndicatorResponseDTO> findIndicatorById(Long id);

    /**
     * Crea un nuevo indicador
     *
     * @param indicatorRequestDTO DTO con los datos para crear un indicador
     * @return El indicador creado
     */
    IndicatorResponseDTO createIndicator(IndicatorRequestDTO indicatorRequestDTO);

    /**
     * Actualiza un indicador
     *
     * @param indicatorRequestDTO DTO con los datos para actualizar un indicador
     * @param id                  Id del indicador a actalizar
     * @return Indicador actualizado
     */
    IndicatorResponseDTO updateIndicator(IndicatorRequestDTO indicatorRequestDTO, Long id);

    /**
     * Elimina un indicador
     *
     * @param id Id del indicador a eliminar
     * @return true si fue eliminado o false si no
     */
    boolean deleteIndicator(Long id);

}
