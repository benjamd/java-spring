package ar.com.benjamd.web;

import ar.com.benjamd.domain.Persona;
import ar.com.benjamd.servicio.PersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        log.info("Ejecutando controlador Spring MVC");
        var personas = personaService.listarPersonas();
        model.addAttribute("personas",personas);
        
        return "index";
    }
    
    @GetMapping("agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    
    @PostMapping("guardar")
    public String guardar(@Valid Persona persona, Errors errors){
        if(errors.hasErrors()){
            return "modificar";
        }
                
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    
    /* 
    Version Path Variable
    En la vista colocar:
     <td><a th:href="@{/eliminar/} + ${persona.idPersona}" th:text="Eliminar"/></td>
    */
    /*
    @GetMapping("eliminar/{idPersona}")
    public String eliminar(Persona persona, Model model){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    */
    
    /*
    Version por query parameter
    en la vista colocar:
     <td><a th:href="@{/eliminar(idPersona=${persona.idPersona)}" th:text="Eliminar"/></td>
    */
    @GetMapping("eliminar")
    public String eliminar(Persona persona, Model model){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
    
}
