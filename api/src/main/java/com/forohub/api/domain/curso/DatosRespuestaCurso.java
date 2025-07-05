package com.forohub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaCurso (@NotNull Long id,
                                   @NotBlank String nombre) {
}
