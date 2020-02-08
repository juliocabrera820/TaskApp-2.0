package com.proyecto.demo.modelo.servicio;

import com.proyecto.demo.modelo.entidad.Tarea;
import com.proyecto.demo.modelo.repositorio.RepositorioTarea;
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
public class ServicioTareaImpl implements ServicioTarea {

    @Autowired
    private RepositorioTarea repositorioTarea;

    /**
     * Función que devuelve los registros de la base de datos
     * @return lista de tareas
     */
    @Override
    public List<Tarea> listar() {
        return (List<Tarea>) repositorioTarea.findAll();
    }

    /**
     * Función que agrega un nuevo registro a la base de datos
     * @param tarea Tarea que se insertará en la base de datos
     */
    @Override
    public void agregar(Tarea tarea) {
        repositorioTarea.save(tarea);
    }

    /**
     * Función para buscar un registro en la base de datos
     * @param id Identificador de la tarea en la base de datos
     * @return
     */
    @Override
    public Tarea editar(int id) {
        return repositorioTarea.findById(id).orElse(null);
    }

    /**
     * Función para eliminar una tarea de la base de datos
     * @param id Identificador de la tarea en la base de datos
     */
    @Override
    public void eliminar(int id) {
        repositorioTarea.deleteById(id);
    }
}
