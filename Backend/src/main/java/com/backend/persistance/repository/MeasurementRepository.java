package com.backend.persistance.repository;

import com.backend.persistance.entity.MeasurementEntity;
import com.backend.presentation.dto.MeasurementIndicatorResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de medidas
 */
@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {

    @Query("SELECT new com.backend.presentation.dto.MeasurementIndicatorResponseDTO(" +
            "i.indicatorName, " +
            "m.description, " +
            "m.measurementDate, " +
            "m.measurementValue, " +
            "CASE " +
            "WHEN m.measurementValue < i.minValue THEN 'RED' " +
            "WHEN m.measurementValue >= i.minValue AND m.measurementValue < i.expectedValue THEN 'YELLOW' " +
            "WHEN m.measurementValue >= i.expectedValue AND m.measurementValue <= i.maxValue THEN 'GREEN' " +
            "WHEN m.measurementValue > i.maxValue THEN 'BLUE' " +
            "ELSE 'UNKNOWN' " +
            "END) " +
            "FROM MeasurementEntity m " +
            "JOIN m.indicator i " +
            "WHERE i.id = :id " +
            "ORDER BY m.measurementDate ASC"
    )
    List<MeasurementIndicatorResponseDTO> findMeasurementsWithStatusByIndicatorId(Long id);

}
