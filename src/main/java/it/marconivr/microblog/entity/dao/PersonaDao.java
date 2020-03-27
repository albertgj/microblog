package it.marconivr.microblog.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.marconivr.microblog.entity.Persona;

@Repository
public interface PersonaDao extends JpaRepository<Persona, Long>
{

}
