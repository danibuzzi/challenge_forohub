package com.forohub.api.controller;

import com.forohub.api.domain.curso.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import jakarta.validation.Valid;

import java.net.URI;


@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<DatosRegistroCurso> registrarCurso(@RequestBody @Valid DatosRegistroCurso datosRegistroCurso,
                                                                UriComponentsBuilder uriComponentsBuilder) {
       Curso curso = cursoRepository.save(new Curso(datosRegistroCurso));
       DatosRegistroCurso datosCurso = new DatosRegistroCurso(curso.getNombre());

        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosCurso);

    }

   @GetMapping
    public ResponseEntity<Page<DatosListadoCursos>> listadoCursos(@PageableDefault(size = 2) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(cursoRepository.findAllByActivoTrue(paginacion).map(DatosListadoCursos::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
       Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(), curso.getNombre()
           ));
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        System.out.println(curso.getId());
        curso.desactivarCurso();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCurso> retornaDatosCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        var datosCurso = new DatosRespuestaCurso(curso.getId(), curso.getNombre());
        return ResponseEntity.ok(datosCurso);
    }
}
