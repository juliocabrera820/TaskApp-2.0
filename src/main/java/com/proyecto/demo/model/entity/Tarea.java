package com.proyecto.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Tarea {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @Size(max = 50,message = "El nombre debe ser menor a 50 caracteres")
    @NotEmpty(message = "Debes ingresar un nombre")
    private String nombre;
    @Column
    @Size(min = 50,message = "La descripcion debe ser mayor a 50 caracteres")
    @Size(max = 100,message = "La descripcion debe ser menor a 100 caracteres")
    @NotEmpty(message = "Debes ingresar una descripcion")
    private String descripcion;
    @Column
    private String prioridad;
    @Column
    private String estado;
    @Column
    @Size(max = 50,message = "El responsable debe ser menor a 50 caracteres")
    @NotEmpty(message = "Debes ingresar un responsable")
    private String responsable;
}
