package com.proyecto.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> listar() {
        return (List<Tarea>) tareaRepository.findAll();
    }

    @Override
    public void agregar(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public Tarea editar(int id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        tareaRepository.deleteById(id);
    }
}
