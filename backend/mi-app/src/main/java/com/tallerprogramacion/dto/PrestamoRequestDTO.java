package com.tallerprogramacion.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PrestamoRequestDTO {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String nombreUsuario;

    @NotEmpty(message = "La lista de libros no puede estar vacía")
    private List<PrestamoDetalleDTO> libros;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<PrestamoDetalleDTO> getLibros() {
        return libros;
    }

    public void setLibros(List<PrestamoDetalleDTO> libros) {
        this.libros = libros;
    }
}