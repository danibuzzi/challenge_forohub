package com.forohub.api.domain.respuesta;


import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

public record DatosActualizarRespuesta(

        @NotBlank
        String mensaje,
        @NotBlank
        Topico topico,
        @NotBlank
        Usuario autor,
        @NotBlank
        Boolean solucion
) {
}
