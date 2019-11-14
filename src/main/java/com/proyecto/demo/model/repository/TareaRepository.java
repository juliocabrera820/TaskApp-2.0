package com.proyecto.demo.model.repository;

import com.proyecto.demo.model.entity.Tarea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends CrudRepository<Tarea, Integer> {
}
