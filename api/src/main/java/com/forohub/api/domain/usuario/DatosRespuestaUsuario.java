package com.forohub.api.domain.usuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaUsuario(
        @NotNull
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String contrasena,
        @Enumerated(EnumType.STRING)
        Tipo tipo
) {
}
