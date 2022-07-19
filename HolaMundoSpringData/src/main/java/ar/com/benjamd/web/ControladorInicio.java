package ar.com.benjamd.web;

import ar.com.benjamd.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
}
