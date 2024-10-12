package com.backend.service.impl;

import com.backend.persistance.entity.IndicatorEntity;
import com.backend.persistance.repository.IndicatorRepository;
import com.backend.presentation.dto.IndicatorRequestDTO;
import com.backend.presentation.dto.IndicatorResponseDTO;
import com.backend.service.interfaces.IndicatorService;
import com.backend.util.mapper.IndicatorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio del indicador
 */
@RequiredArgsConstructor
@Service
public class IndicatorServiceImpl implements IndicatorService {

    /**
     * Repositorio del indicador
     */
    private final IndicatorRepository indicatorRepository;
    /**
     * Mapeador del indicador
     */
    private final IndicatorMapper indicatorMapper;

    /**
     * Obtiene todos los indicadores registrados
     *
     * @return Un List con todos los indicadores
     */
    @Override
    public List<IndicatorResponseDTO> findAll() {
        return indicatorMapper.toIndicatorResponseDtoList(
                indicatorRepository.findAll()
        );
    }

    /**
     * Obtiene un indicador
     *
     * @param id Id del indicador a obtener
     * @return Un Optional del indicador obtenido
     */
    @Override
    public Optional<IndicatorResponseDTO> findIndicatorById(Long id) {
        return indicatorRepository.findById(id)
                .map(indicatorMapper::toIndicatorResponseDto);
    }

    /**
     * Crea un nuevo indicador
     *
     * @param indicatorRequestDTO DTO con los datos para crear un indicador
     * @return El indicador creado
     */
    @Override
    public IndicatorResponseDTO createIndicator(IndicatorRequestDTO indicatorRequestDTO) {
        return indicatorMapper.toIndicatorResponseDto(
                indicatorRepository.save(
                        indicatorMapper.toIndicatorEntity(indicatorRequestDTO)
                )
        );
    }

    /**
     * Actualiza un indicador
     *
     * @param indicatorRequestDTO DTO con los datos para actualizar un indicador
     * @param id                  Id del indicador a actalizar
     * @return Indicador actualizado
     */
    @Override
    public IndicatorResponseDTO updateIndicator(IndicatorRequestDTO indicatorRequestDTO, Long id) {
        IndicatorEntity newIndicatorEntity = indicatorMapper.toIndicatorEntity(indicatorRequestDTO);
        newIndicatorEntity.setId(id);

        return indicatorMapper.toIndicatorResponseDto(
                indicatorRepository.save(newIndicatorEntity)
        );
    }

    /**
     * Elimina un indicador
     *
     * @param id Id del indicador a eliminar
     * @return true si fue eliminado o false si no
     */
    @Override
    public boolean deleteIndicator(Long id) {
        Optional<IndicatorEntity> indicatorEntityOptional = indicatorRepository.findById(id);
        if (indicatorEntityOptional.isEmpty()) return false;
        indicatorRepository.deleteById(id);
        return true;
    }
}
