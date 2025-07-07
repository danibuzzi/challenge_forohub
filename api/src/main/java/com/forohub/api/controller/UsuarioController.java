package com.forohub.api.controller;


import com.forohub.api.domain.curso.*;
import com.forohub.api.domain.usuario.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRegistroUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                             UriComponentsBuilder uriComponentsBuilder) {
    Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
        DatosRegistroUsuario datosUsuario = new DatosRegistroUsuario(usuario.getNombre(),
        usuario.getEmail(),usuario.getContrasena(),usuario.getTipo());

        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(datosUsuario);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuarios>> listadoCursos(@PageableDefault(size = 2) Pageable paginacion) {
//        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListadoUsuarios::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario =  usuarioRepository.getReferenceById(datosActualizarUsuario.id());
       usuario.actualizarDatos(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail(),usuario.getContrasena(),usuario.getTipo()));


    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        //System.out.println(curso.getId());
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaUsuario> retornaDatosUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        var datosUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail(),usuario.getContrasena(),usuario.getTipo());
        return ResponseEntity.ok(datosUsuario);
    }
}
