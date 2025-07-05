package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(

            @NotBlank
            String titulo,
            @NotBlank
            String mensaje,
            @NotBlank
            Usuario autor,
            @NotBlank
            Curso curso

) {
}
