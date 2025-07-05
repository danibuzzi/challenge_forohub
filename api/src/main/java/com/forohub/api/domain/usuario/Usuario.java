package com.forohub.api.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
*/
import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Tipo tipo = Tipo.ROLE_USER;

    public Usuario(DatosRegistroUsuario datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.contrasena = datos.contrasena();
        if (datos.tipo() != this.tipo) {
            this.tipo = datos.tipo();
        }
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizar) {
        if (datosActualizar.nombre() != null) {
            this.nombre = datosActualizar.nombre();
        }
        if (datosActualizar.email() != null) {
            this.email = datosActualizar.email();
        }
        if (datosActualizar.contrasena() != null) {
            this.contrasena = datosActualizar.contrasena();
        }
        if (datosActualizar.tipo() != datosActualizar.tipo()) {
            this.tipo = datosActualizar.tipo();
        }

    }


}
