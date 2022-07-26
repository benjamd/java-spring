package ar.com.benjamd.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
    
    private static final long seriaversionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    
}
