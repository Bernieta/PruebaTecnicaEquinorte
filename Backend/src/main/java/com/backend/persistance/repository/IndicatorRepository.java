package com.backend.persistance.repository;

import com.backend.persistance.entity.IndicatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio del indicador
 */
@Repository
public interface IndicatorRepository extends JpaRepository<IndicatorEntity, Long> {
}
