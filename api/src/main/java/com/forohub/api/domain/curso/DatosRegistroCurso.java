package com.forohub.api.domain.curso;
import jakarta.validation.constraints.NotBlank;
public record DatosRegistroCurso(

        @NotBlank
        String nombre
) {
}
