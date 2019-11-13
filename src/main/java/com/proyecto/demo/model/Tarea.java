package com.proyecto.demo.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Tarea {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotEmpty(message = "Debes ingresar un nombre")
    private String nombre;
    @Column
    @NotEmpty(message = "Debes ingresar una descripcion")
    private String descripcion;
    @Column
    private String prioridad;
    @Column
    private String estado;
    @Column
    @NotEmpty(message = "Debes ingresar un responsable")
    private String responsable;
}
