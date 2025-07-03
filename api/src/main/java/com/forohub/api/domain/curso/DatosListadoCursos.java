package com.forohub.api.domain.curso;



public record DatosListadoCursos(Long id, String nombre) {

    public DatosListadoCursos(Curso curso) {
        this(curso.getId(), curso.getNombre());
    }
}
