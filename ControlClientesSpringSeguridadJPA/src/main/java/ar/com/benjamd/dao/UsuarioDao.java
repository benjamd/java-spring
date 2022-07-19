package ar.com.benjamd.dao;

import ar.com.benjamd.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{

    public Usuario findByUsername(String username);
}
