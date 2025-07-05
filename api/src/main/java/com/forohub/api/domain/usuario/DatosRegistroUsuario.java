package com.forohub.api.domain.usuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank(message = "nada")
        String nombre,
        @NotBlank(message = "hola")
        String email,
        @NotBlank (message = "dos")
        String contrasena,
        @Enumerated(EnumType.STRING)
        Tipo tipo


) {
}
