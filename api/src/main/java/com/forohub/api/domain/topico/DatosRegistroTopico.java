package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

            @NotBlank
            String titulo,
            @NotBlank
            String mensaje,
            @NotNull
            Long autorId,
            @NotNull
            Long cursoId

) {
}
