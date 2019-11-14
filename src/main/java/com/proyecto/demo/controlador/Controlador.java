package com.proyecto.demo.controlador;

import com.proyecto.demo.model.entity.Tarea;
import com.proyecto.demo.model.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class Controlador {

    private List<String> estados;
    private List<String> prioridades;

    public Controlador() {
        estados = Arrays.asList("En espera","En progreso","Terminado");
        prioridades = Arrays.asList("Alta","Media","Baja");
    }

    @Autowired
    private TareaService tareaService;

    @GetMapping("/")
    public String listar(Model model){
        List<Tarea> tareas = tareaService.listar();
        model.addAttribute("tareas",tareas);
        return "index";
    }

    @GetMapping("/crear")
    public String crear(Model model){
        Tarea tarea = new Tarea();
        model.addAttribute("titulo","Crear Tarea");
        model.addAttribute("tarea",tarea);
        model.addAttribute("estados",estados);
        model.addAttribute("prioridades",prioridades);
        return "formTarea";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Tarea tarea, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("tarea",tarea);
            model.addAttribute("estados",estados);
            model.addAttribute("prioridades",prioridades);
            return "/formTarea";
        }
        tareaService.agregar(tarea);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model,@PathVariable("id") int id){
        model.addAttribute("titulo","Editar Tarea");
        Tarea tarea = tareaService.editar(id);
        model.addAttribute("tarea",tarea);
        model.addAttribute("estados",estados);
        model.addAttribute("prioridades",prioridades);
        return "formTarea";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id){
        tareaService.eliminar(id);
        return "redirect:/";
    }
}
