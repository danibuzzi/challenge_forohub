package com.forohub.api.domain.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoReppsitory extends JpaRepository<Curso,Long> {
    Page<Curso> findAllByActivoTrue(Pageable paginacion);

}
