package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(


        @NotBlank
        String mensaje,
        @NotNull
        Long topicoId,
        @NotNull
        Long autorId,
        @NotBlank
        Boolean solucion
) {
}
