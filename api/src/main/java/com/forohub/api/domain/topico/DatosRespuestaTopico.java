package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.DatosRespuestaCurso;
import com.forohub.api.domain.usuario.DatosRespuestaUsuario;

public record DatosRespuestaTopico(String titulo, String mensaje, String autor, String curso) {

    public DatosRespuestaTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}