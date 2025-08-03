package com.example.forohub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        @NotBlank String nombre,
        @NotBlank String clave
) {
}