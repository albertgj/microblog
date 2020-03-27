package it.marconivr.microblog.service;

import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.entity.Post;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author albert
 */

public interface PersonaService
{
    public List<Persona> findAll();
    public Optional<Persona> findById(Long id);
    public Optional<Post> findPost(Long id);
    public Persona savePersona(Persona p);
}
