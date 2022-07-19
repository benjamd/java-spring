package ar.com.benjamd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ControladorInicio {
    
    @GetMapping("/")
    public String inicio(){
        log.info("Ejecutando controlador rest");
        log.debug("mas detalle a nivel controller");
        return "Hola Mundo con Spring Boot 2!!!";
    }
}
