package ar.com.benjamd.dao;

import ar.com.benjamd.domain.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonaDao extends CrudRepository<Persona, Long>{
   
}
