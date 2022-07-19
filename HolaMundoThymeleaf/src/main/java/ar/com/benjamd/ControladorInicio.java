package ar.com.benjamd;

import ar.com.benjamd.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var mensaje = "Hola mundo con thymeleaf";
        log.info("Ejecutando controlador Spring MVC");
        
        var persona = new Persona();
        persona.setNombre("juan");
        persona.setApellido("perez");
        persona.setTelefono("1512315512");
        persona.setEmail("juancitop@hotmail.com");
       
        var persona2 = new Persona();
        persona2.setNombre("Claudia");
        persona2.setApellido("Burgos");
        persona2.setTelefono("1545210965");
        persona2.setEmail("cburgos@hotmail.com");
       
        List<Persona> personas = new ArrayList();
       // personas.add(persona);
       // personas.add(persona2);
        
        
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("saludo",saludo);
        model.addAttribute("personas",personas);
        
        return "index";
    }
}
