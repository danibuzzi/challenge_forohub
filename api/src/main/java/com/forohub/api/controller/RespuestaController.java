package com.forohub.api.controller;


import com.forohub.api.domain.respuesta.*;
import com.forohub.api.domain.topico.Estado;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.topico.TopicoRepository;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
   @Autowired
    private RespuestaRepository respuestaRepository;
   @Autowired
    private  TopicoRepository topicoRepository;
   @Autowired
    private  UsuarioRepository usuarioRepository;

    /*public RespuestaController(RespuestaRepository respuestaRepository, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository) {
        this.respuestaRepository = respuestaRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }*/

    @PostMapping
    public ResponseEntity<DatosRetornoRespuesta> registrar(@RequestBody DatosRegistroRespuesta datosRegistro, UriComponentsBuilder uri) {
        Topico topico = topicoRepository.getReferenceById(datosRegistro.topicoId());
        if (topico.getEstado() == Estado.CERRADO) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Usuario autor = usuarioRepository.getReferenceById(datosRegistro.autorId());
        Respuesta respuesta = respuestaRepository.save(new Respuesta(datosRegistro, topico, autor));
        topico.agregarRespuesta(respuesta);
        DatosRetornoRespuesta datosRespuesta = new DatosRetornoRespuesta(respuesta);
        URI url = uri.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);

       }
        @GetMapping
        public ResponseEntity<Page<DatosListadoRespuesta>> listar (@PageableDefault(size = 10) Pageable paginacion){
            return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new));
        }

        @GetMapping("/{id}")
        public ResponseEntity<DatosRetornoRespuestaId> retornaDatos (@PathVariable Long id){
            Respuesta respuesta = respuestaRepository.getReferenceById(id);
            return ResponseEntity.ok(new DatosRetornoRespuestaId(respuesta));
        }

        @PutMapping
        @Transactional
        public ResponseEntity<DatosActualizarRespuesta> actualizar (@RequestBody DatosActualizarRespuesta datosActualizarRespuesta){
            Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.Id());
            Topico topico = topicoRepository.getReferenceById(datosActualizarRespuesta.topico_id());
            Usuario autor = usuarioRepository.getReferenceById(datosActualizarRespuesta.autor_id());
            respuesta.actualizarDatosRespuesta(datosActualizarRespuesta, topico, autor);
            return ResponseEntity.ok(new DatosActualizarRespuesta(respuesta.getId(),
                    respuesta.getMensaje(), respuesta.getTopico().getId(),
                    respuesta.getAutor().getId(),respuesta.getSolucion()));

        }

        @DeleteMapping("/{id}")
        @Transactional
        public ResponseEntity<Void> eliminar (@PathVariable Long id){
            Respuesta respuesta = respuestaRepository.getReferenceById(id);
            respuestaRepository.delete(respuesta);
            return ResponseEntity.noContent().build();
        }
    }
