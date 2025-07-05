package com.forohub.api.controller;


import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.curso.CursoRepository;
import com.forohub.api.domain.topico.*;
import com.forohub.api.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")

public class TopicoController {
    @Autowired
    private  TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

   /*private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }*/
    @PostMapping
    public ResponseEntity<DatosRegistroTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                               UriComponentsBuilder uriComponentsBuilder) {

        Usuario autor=usuarioRepository.getReferenceById(datosRegistroTopico.autorId());
        Curso curso=cursoRepository.findById(datosRegistroTopico.cursoId()).get();
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico,autor,curso));
        DatosRegistroTopico datosTopico = new DatosRegistroTopico(topico.getTitulo(), topico.getMensaje()
                , topico.getAutor().getId(), topico.getCurso().getId());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosTopico);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Usuario autor=usuarioRepository.getReferenceById(datosActualizarTopico.autorId());
        //System.out.println("Autor id "+datosActualizarTopico.autorId());
        Curso curso=cursoRepository.getReferenceById(datosActualizarTopico.cursoId());
        //System.out.println("Curso id" +datosActualizarTopico.cursoId());
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico,autor,curso);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(),
                topico.getMensaje(), topico.getAutor().getNombre(), topico.getCurso().getNombre()));


    }

    // DELETE
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        //System.out.println(curso.getId());
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(),
                topico.getAutor().getNombre(), topico.getCurso().getNombre());
        return ResponseEntity.ok(datosTopico);
    }

}

