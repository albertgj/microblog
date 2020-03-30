package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.dao.PersonaDao;
import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.PersonaService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    @PersistenceContext
    private EntityManager em;

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
        return personaDao.saveAndFlush(p);
    }

    @Override
    public void deleteById(Long id)
    {
        personaDao.deleteById(id);
    }

    @Override
    public List<Post> findPostsOfUser(Long id)
    {
        TypedQuery<Post> typedQuery = em.createQuery("SELECT u FROM Post u WHERE u.persona.id = :p", Post.class).setParameter("p", personaDao.findById(id).get().getId());
        List<Post> listaPost = typedQuery.setMaxResults(10).getResultList();
        
        return listaPost;
    }
}
