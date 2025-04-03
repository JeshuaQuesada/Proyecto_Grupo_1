

package com.example.Calificaciones.Domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "calificaciones")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String libro;
    private int puntuacion;
    private String comentario;

}
