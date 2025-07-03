package com.forohub.api.domain.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import lombok.EqualsAndHashCode;



    @Table(name = "cursos")
    @Entity(name = "Curso")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")

    public class Curso {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private Boolean activo;

        public Curso(DatosRegistroCurso datosCurso) {
            this.activo=true;
            this.nombre = datosCurso.nombre();

        }

        public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
            if (datosActualizarCurso.nombre() != null) {
                this.nombre = datosActualizarCurso.nombre();
            }
           /* if (datosActualizarMedico.documento() != null) {
                this.documento = datosActualizarMedico.documento();
            }
            if (datosActualizarMedico.direccion() != null) {
                this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
            }*/
        }

        public void desactivarCurso() {
            this.activo=false;
        }

    }

