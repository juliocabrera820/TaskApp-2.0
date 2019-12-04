package com.proyecto.demo.model.service;

import com.proyecto.demo.model.entity.Tarea;
import com.proyecto.demo.model.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author julio-cabrera
 * @author isaac-canche
 * @author leoncio-montalvo
 * @author emmanuel-rivero
 * @version 2.0
 */
@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    /**
     * Función que devuelve los registros de la base de datos
     * @return lista de tareas
     */
    @Override
    public List<Tarea> listar() {
        return (List<Tarea>) tareaRepository.findAll();
    }

    /**
     * Función que agrega un nuevo registro a la base de datos
     * @param tarea Tarea que se insertará en la base de datos
     */
    @Override
    public void agregar(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    /**
     * Función para buscar un registro en la base de datos
     * @param id Identificador de la tarea en la base de datos
     * @return
     */
    @Override
    public Tarea editar(int id) {
        return tareaRepository.findById(id).orElse(null);
    }

    /**
     * Función para eliminar una tarea de la base de datos
     * @param id Identificador de la tarea en la base de datos
     */
    @Override
    public void eliminar(int id) {
        tareaRepository.deleteById(id);
    }
}
