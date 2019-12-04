package com.proyecto.demo.model.service;

import com.proyecto.demo.model.entity.Tarea;
import java.util.List;

/**
 * @author julio-cabrera
 * @author isaac-canche
 * @author leoncio-montalvo
 * @author emmanuel-rivero
 * @version 2.0
 */
public interface TareaService {
    /**
     * Función que devuelve una lista de tipo Tarea
     * @return lista de tipo Tarea
     */
    public List<Tarea> listar();

    /**
     * Función para agregar una nueva tarea
     * @param tarea Tarea
     */
    public void agregar(Tarea tarea);

    /**
     * Función que busca una tarea
     * @param id Identificador de la tarea
     * @return Tarea encontrada
     */
    public Tarea editar(int id);

    /**
     * Eliminar tarea
     * @param id Identificador de la tarea
     */
    public void eliminar(int id);
}
