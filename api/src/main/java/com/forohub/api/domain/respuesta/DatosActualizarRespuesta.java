package com.forohub.api.domain.respuesta;


import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull
        Long Id,
        @NotBlank
        String mensaje,
        @NotNull
        Long topico_id,
        @NotNull
        Long autor_id,
        @NotBlank
        Boolean solucion
) {



        /*public DatosActualizarRespuesta(Respuesta respuesta) {
                this.Id=respuesta.getId();
                this.mensaje=respuesta.getMensaje();
                this.autor=respuesta.getAutor().getId();

        }*/
}
