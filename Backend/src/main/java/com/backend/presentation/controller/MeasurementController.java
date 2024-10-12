package com.backend.presentation.controller;

import com.backend.presentation.dto.MeasurementIndicatorResponseDTO;
import com.backend.presentation.dto.MeasurementRequestDTO;
import com.backend.presentation.dto.MeasurementResponseDTO;
import com.backend.service.impl.MeasurementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de medidas
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    /**
     * Servicio de medidas
     */
    private final MeasurementServiceImpl measurementService;

    /**
     * Obtiene una lista de indicadores de medición con su estado, filtrados por el ID del indicador.
     *
     * @param id El identificador del indicador por el cual se buscan las mediciones.
     * @return ResponseEntity que contiene una lista de indicadores con sus mediciones
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<MeasurementIndicatorResponseDTO>> findMeasurementsWithStatusByIndicatorId(@PathVariable Long id) {
        return new ResponseEntity<>(
                measurementService.findMeasurementsWithStatusByIndicatorId(id),
                HttpStatus.OK
        );
    }

    /**
     * Crea una nueva medición.
     *
     * @param measurementRequestDTO DTO con los datos de creación de la medición.
     * @return ResponseEntity de la medicion creada
     */
    @PostMapping
    public ResponseEntity<MeasurementResponseDTO> createMeasurement(@RequestBody MeasurementRequestDTO measurementRequestDTO) {
        return new ResponseEntity<>(
                measurementService.createMeasurement(measurementRequestDTO),
                HttpStatus.CREATED
        );
    }
}
