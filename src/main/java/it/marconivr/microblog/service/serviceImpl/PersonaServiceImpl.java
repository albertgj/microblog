package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.dao.PersonaDao;
import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.PersonaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author albert
 */
@Service
public class PersonaServiceImpl implements PersonaService
{
@Autowired
    private PersonaDao personaDao;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public List<Persona> findAll()
    {
        return personaDao.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id)
    {
        return personaDao.findById(id);
    }

    @Override
    public Persona save(Persona p)
    {
        Persona persona = new Persona();
        persona.setUsername(p.getUsername());
        persona.setPassword(bcryptEncoder.encode(p.getPassword()));
        
        return personaDao.saveAndFlush(persona);
    }

    @Override
    public void deleteById(Long id)
    {
        personaDao.deleteById(id);
    }

    @Override
    public List<Post> getPostsOfUser(Long id)
    {
        return personaDao.findPostsOfUser(id);
    }

    @Override
    public Persona findByUsername(String username)
    {
        return personaDao.findByUsername(username);
    }
}
