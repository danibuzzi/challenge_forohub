package com.forohub.api.domain.usuario;

import com.forohub.api.domain.curso.Curso;

public record DatosListadoUsuarios(Long id, String nombre,String email
,String contrasena,Tipo tipo) {

    public DatosListadoUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getContrasena(),usuario.getTipo());
    }
}