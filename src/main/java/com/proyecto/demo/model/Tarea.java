package com.proyecto.demo.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Tarea {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String descripcion;
    @Column
    private String prioridad;
    @Column
    private String estado;
    @Column
    private String responsable;
}
