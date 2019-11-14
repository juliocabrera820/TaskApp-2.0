package com.proyecto.demo.model.service;

import com.proyecto.demo.model.entity.Tarea;

import java.util.List;

public interface TareaService {
    public List<Tarea> listar();
    public void agregar(Tarea tarea);
    public Tarea editar(int id);
    public void eliminar(int id);
}
