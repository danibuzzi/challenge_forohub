package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.usuario.Usuario;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso

) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}