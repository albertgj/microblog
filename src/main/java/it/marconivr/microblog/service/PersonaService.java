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
    public Persona findByUsername(String username);
    public Persona save(Persona p);
    public void deleteById(Long id);
    public List<Post> getPostsOfUser(Long id);
}
