package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topico.DatosRespuestaTopico;
import com.forohub.api.domain.usuario.DatosRespuestaUsuario;

public record DatosRetornoRespuestaId(String mensaje, DatosRespuestaTopico topico, String fechaCreacion, DatosRespuestaUsuario autor, String solucion) {

    public DatosRetornoRespuestaId(Respuesta respuesta) {
        this(respuesta.getMensaje(), new DatosRespuestaTopico(respuesta.getTopico()), respuesta.getFechaCreacion().toString(),
                new DatosRespuestaUsuario(respuesta.getAutor().getId(),respuesta.getAutor().getNombre(),
                respuesta.getAutor().getEmail(),respuesta.getAutor().getContrasena(),

                respuesta.getAutor().getTipo()) , respuesta.getSolucion().toString());
    }
}