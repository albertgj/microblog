package it.marconivr.microblog.controller;

import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.entity.dao.PersonaDao;
import it.marconivr.microblog.entity.dao.PostDao;
import it.marconivr.microblog.service.PersonaService;

@Component
@Path("/persone")
public class PersonaController
{
    @Autowired
    private PersonaService personaService;
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> findAll()
    {
        return personaService.findAll();
    }

    @GET
    @Path("/posts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Post> findPosts(@PathParam("id") Long id)
    {
        //Persona p = personaRep.findById(id).get();

        return personaService.findPost(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Persona newPersona(Persona p)
    {
        return personaService.savePersona(p);
    }
}
