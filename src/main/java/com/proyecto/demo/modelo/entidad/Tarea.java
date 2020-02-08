package com.proyecto.demo.modelo.entidad;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Debes ingresar un nombre")
    private String nombre;
    @Column
    @Size(max = 100,message = "La descripcion debe ser menor a 100 caracteres")
    @NotBlank(message = "Debes ingresar una descripcion")
    private String descripcion;
    @Column
    private String prioridad;
    @Column
    private String estado;
    @Column
    @Size(max = 50,message = "El responsable debe ser menor a 50 caracteres")
    @NotBlank(message = "Debes ingresar un responsable")
    private String responsable;
}
