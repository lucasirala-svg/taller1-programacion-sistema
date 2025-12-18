package com.tallerprogramacion.service;

import com.tallerprogramacion.dto.PrestamoRequestDTO;
import com.tallerprogramacion.dto.PrestamoResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PrestamoService {

    private final Map<Long, PrestamoResponseDTO> prestamosEnMemoria = new ConcurrentHashMap<>();
    private final AtomicLong contadorId = new AtomicLong();

    public PrestamoResponseDTO registrarPrestamo(PrestamoRequestDTO request) {
        Long nuevoId = contadorId.incrementAndGet();

        PrestamoResponseDTO nuevoPrestamo = new PrestamoResponseDTO();
        nuevoPrestamo.setId(nuevoId);
        nuevoPrestamo.setNombreUsuario(request.getNombreUsuario());
        nuevoPrestamo.setLibros(request.getLibros());
        nuevoPrestamo.setFechaPrestamo(LocalDateTime.now());
        nuevoPrestamo.setTotalLibros(request.getLibros().size());

        prestamosEnMemoria.put(nuevoId, nuevoPrestamo);

        return nuevoPrestamo;
    }

    public List<PrestamoResponseDTO> listarTodos() {
        return new ArrayList<>(prestamosEnMemoria.values());
    }

    public PrestamoResponseDTO buscarPorId(Long id) {
        PrestamoResponseDTO prestamo = prestamosEnMemoria.get(id);
        if (prestamo == null) {
            throw new RuntimeException("Préstamo no encontrado con id: " + id);
        }
        return prestamo;
    }
}