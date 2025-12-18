package com.tallerprogramacion.controller;

import com.tallerprogramacion.dto.PrestamoRequestDTO;
import com.tallerprogramacion.dto.PrestamoResponseDTO;
import com.tallerprogramacion.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public ResponseEntity<PrestamoResponseDTO> registrar(@Valid @RequestBody PrestamoRequestDTO request) {
        PrestamoResponseDTO response = prestamoService.registrarPrestamo(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PrestamoResponseDTO>> listar() {
        List<PrestamoResponseDTO> response = prestamoService.listarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoResponseDTO> obtenerPorId(@PathVariable Long id) {
        PrestamoResponseDTO response = prestamoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }
}