package com.proyecto.demo.model.service;

import com.proyecto.demo.model.entity.Tarea;
import com.proyecto.demo.model.repository.TareaRepository;
import com.proyecto.demo.model.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

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
