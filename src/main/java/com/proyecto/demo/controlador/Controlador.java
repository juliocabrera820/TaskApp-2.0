package com.proyecto.demo.controlador;

import com.proyecto.demo.modelo.entidad.Tarea;
import com.proyecto.demo.modelo.servicio.ServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/**
 * @author julio-cabrera
 * @author isaac-canche
 * @author leoncio-montalvo
 * @author emmanuel-rivero
 * @version 2.0
 */

@Controller
public class Controlador {

    @Autowired
    private ServicioTarea servicioTarea;
    private List<String> estados;
    private List<String> prioridades;

    /**
     * Constructor
     * Inicializa las listas de estados y prioridades que se mostrarán en el formulario
     */
    public Controlador() {
        estados = Arrays.asList("En espera","En progreso","Terminado");
        prioridades = Arrays.asList("Alta","Media","Baja");
    }

    /**
     * Función que devuelve la vista principal con las tareas
     * @param model Atributo que permite enviar a la vista principal la lista de tareas
     * @return página principal
     */
    @GetMapping("/")
    public String listar(Model model){
        List<Tarea> tareas = servicioTarea.listar();
        model.addAttribute("tareas",tareas);
        return "index";
    }

    /**
     * Función que envía un objeto de tipo Tarea sin datos a la vista formTarea
     * @param model Atributo que permite enviar a la vista un título,Objeto de tipo tarea sin datos,
     *              y la lista de estados y prioridades
     * @return vista para agregar una nueva tarea
     */
    @GetMapping("/crear")
    public String crear(Model model){
        Tarea tarea = new Tarea();
        model.addAttribute("titulo","Crear Tarea");
        model.addAttribute("tarea",tarea);
        model.addAttribute("estados",estados);
        model.addAttribute("prioridades",prioridades);
        return "formTarea";
    }

    /**
     * Función para agregar una nueva tarea a la base de datos
     * @param tarea Objeto de tipo tarea con los campos llenados
     * @param bindingResult Objeto que tiene la finalidad de validar si se cumplen las condiciones establecidas en la clase Tarea
     * @param model Envía la tarea antes llenada, la lista de estados y prioridades a la vista formTarea
     *              para llenar correctamente los campos
     * @param attributes Atributo que permite enviar un mensaje de confirmación a la vista principal
     * @return formTarea vista mostrada en caso de no llenar los campos correctamente
     * @return redirect:/ redirige a la vista principal
     */
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Tarea tarea, BindingResult bindingResult, Model model,RedirectAttributes attributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("tarea",tarea);
            model.addAttribute("estados",estados);
            model.addAttribute("prioridades",prioridades);
            return "formTarea";
        }
        servicioTarea.agregar(tarea);
        attributes.addFlashAttribute("guardado","La tarea se guardó");
        return "redirect:/";
    }

    /**
     * Función para editar una tarea
     * @param model Atributo que envía un título,Objeto de tipo tarea y la lista de estados y prioridades
     * @param id Identificador de la tara enviado desde la vista principal
     * @param attributes Objeto que permite enviar un mensaje de error a la vista principal en caso de no existir
     *                   el registro en la base de datos
     * @return formTarea vista con los datos recuperados de la base de datos
     * @return redirect:/ redirigir a la vista principal con un mensaje de error
     */
    @GetMapping("/editar/{id}")
    public String editar(Model model,@PathVariable("id") int id,RedirectAttributes attributes){
        Optional<Tarea> tareaOp = Optional.ofNullable(servicioTarea.editar(id));
        if(tareaOp.isPresent()){
            model.addAttribute("titulo","Editar Tarea");
            Tarea tarea = servicioTarea.editar(id);
            model.addAttribute("tarea",tarea);
            model.addAttribute("estados",estados);
            model.addAttribute("prioridades",prioridades);
            return "formTarea";
        }
        attributes.addFlashAttribute("editado","Error al editar la tarea");
        return "redirect:/";
    }

    /**
     * Función para eliminar una tarea de la base de datos
     * @param id Identificador de la tara enviado desde la vista principal
     * @param attributes Objeto que permite enviar a la vista principal un mensaje
     * @return redirigir a la vista principal con un mensaje
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id,RedirectAttributes attributes){
        Optional<Tarea> tareaOp = Optional.ofNullable(servicioTarea.editar(id));
        if (tareaOp.isPresent()){
            servicioTarea.eliminar(id);
            attributes.addFlashAttribute("eliminado","La tarea ha sido eliminada");
            return "redirect:/";
        }
        attributes.addFlashAttribute("eliminado","Error al eliminar la tarea");
        return "redirect:/";
    }
}
