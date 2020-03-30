package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author albert
 */
@Repository
public interface PersonaDao extends JpaRepository<Persona, Long>
{
    
}
