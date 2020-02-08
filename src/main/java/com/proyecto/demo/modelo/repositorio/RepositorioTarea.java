package com.proyecto.demo.modelo.repositorio;

import com.proyecto.demo.modelo.entidad.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTarea extends CrudRepository<Tarea, Integer> {
}
