package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.entity.dao.PersonaDao;
import it.marconivr.microblog.entity.dao.PostDao;
import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PostDao postDao;
    
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
    public Optional<Post> findPost(Long id)
    {
        return postDao.findById(id);
    }

    @Override
    public Persona savePersona(Persona p)
    {
        return personaDao.saveAndFlush(p);
    }
}
