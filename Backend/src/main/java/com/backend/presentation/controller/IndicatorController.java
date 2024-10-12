package com.backend.presentation.controller;

import com.backend.presentation.dto.IndicatorRequestDTO;
import com.backend.presentation.dto.IndicatorResponseDTO;
import com.backend.service.impl.IndicatorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador del indicador
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/indicators")
public class IndicatorController {

    /**
     * Servicio del indicador
     */
    private final IndicatorServiceImpl indicatorService;

    /**
     * Recupera una lista de todos los indicadores.
     *
     * @return ResponseEntity que contiene una lista de indicadores
     */
    @GetMapping
    public ResponseEntity<List<IndicatorResponseDTO>> findAll() {
        return new ResponseEntity<>(indicatorService.findAll(), HttpStatus.OK);
    }

    /**
     * Recupera un indicador específico por su id.
     *
     * @param id el identificador único del indicador a recuperar
     * @return ResponseEntity que contiene un Optional de indicadores
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<IndicatorResponseDTO>> findIndicatorById(@PathVariable Long id) {
        return new ResponseEntity<>(indicatorService.findIndicatorById(id), HttpStatus.OK);
    }

    /**
     * Crea un nuevo indicador.
     *
     * @param indicatorRequestDTO el DTO que contiene el nuevo indicador
     * @return ResponseEntity que contiene el indicador creado
     */
    @PostMapping
    public ResponseEntity<IndicatorResponseDTO> createIndicator(@RequestBody IndicatorRequestDTO indicatorRequestDTO) {
        return new ResponseEntity<>(indicatorService.createIndicator(indicatorRequestDTO), HttpStatus.CREATED);
    }

    /**
     * Actualiza un nuevo indicador.
     *
     * @param indicatorRequestDTO el DTO que contiene el indicador a actulizar
     * @param id                  el identificador del indicador a actualizar
     * @return ResponseEntity que contiene el indicador actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<IndicatorResponseDTO> updateIndicator(@RequestBody IndicatorRequestDTO indicatorRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(indicatorService.updateIndicator(indicatorRequestDTO, id), HttpStatus.OK);
    }

    /**
     * Elimina un indicador por su id.
     *
     * @param id el identificador del indicador a eliminar
     * @return ResponseEntity con el estado 204 si la eliminación es exitosa,
     * o el estado 404 si el indicador no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIndicator(@PathVariable Long id) {
        return new ResponseEntity<>(indicatorService.deleteIndicator(id) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }

}
