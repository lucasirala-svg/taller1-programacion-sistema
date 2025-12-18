package com.tallerprogramacion.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PrestamoResponseDTO {

    private Long id;
    private String nombreUsuario;
    private LocalDateTime fechaPrestamo;
    private int totalLibros;
    private List<PrestamoDetalleDTO> libros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getTotalLibros() {
        return totalLibros;
    }

    public void setTotalLibros(int totalLibros) {
        this.totalLibros = totalLibros;
    }

    public List<PrestamoDetalleDTO> getLibros() {
        return libros;
    }

    public void setLibros(List<PrestamoDetalleDTO> libros) {
        this.libros = libros;
    }
}