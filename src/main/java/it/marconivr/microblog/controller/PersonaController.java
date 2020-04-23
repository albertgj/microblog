package it.marconivr.microblog.controller;

import com.holonplatform.jaxrs.swagger.annotations.ApiConfiguration;
import com.holonplatform.jaxrs.swagger.annotations.ApiDefinition;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.service.PersonaService;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author albert
 */
@ApiConfiguration(path = "/api/docs")
@Api("Test API")
@Component
@Path("/persone")
public class PersonaController
{

    @Autowired
    private PersonaService personaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> findAll()
    {
        /*
        if (!personaService.findAll().isEmpty())
        {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), personaService.findAll()));
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(), null));
        }
         */
        return personaService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> findById(@PathParam("id") Long id)
    {
        if (personaService.findById(id).isPresent())
        {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), personaService.findById(id)));
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(), null));
        }
    }

    @GET
    @Path("/posts/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> findAllPosts(@PathParam("id") Long id)
    {
        if (!personaService.getPostsOfUser(id).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), personaService.getPostsOfUser(id)));
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(), null));
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> save(Persona p)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new JsonResponseBody(HttpStatus.CREATED.value(), personaService.save(p)));
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> deleteById(@PathParam("id") Long id)
    {
        personaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new JsonResponseBody(HttpStatus.NO_CONTENT.value(), null));
    }

    @AllArgsConstructor
    class JsonResponseBody
    {

        @Getter
        @Setter
        private int server;
        @Getter
        @Setter
        private Object response;
    }
}
