package it.marconivr.microblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.marconivr.microblog.service.PersonaService;
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
@Component
@Path("/persone")
@Api("Persona Controller")
public class PersonaController
{

    @Autowired
    private PersonaService personaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retrives all users", httpMethod = "GET", code = 200, produces = "application/json")
    public ResponseEntity<JsonResponseBody> findAll()
    {

        if (!personaService.findAll().isEmpty())
        {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), personaService.findAll()));
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(), null));
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retrives user by id", httpMethod = "GET", code = 200, produces = "application/json")
    public ResponseEntity<JsonResponseBody> findById(@ApiParam @PathParam("id") Long id)
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
    @ApiOperation(value = "Retrives posts of a user by id", httpMethod = "GET", code = 200, produces = "application/json")
    public ResponseEntity<JsonResponseBody> findAllPosts(@ApiParam @PathParam("id") Long id)
    {
        if (!personaService.getPostsOfUser(id).isEmpty())
        {
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), personaService.getPostsOfUser(id)));
        } else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponseBody(HttpStatus.NOT_FOUND.value(), null));
        }

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Deletes user by id", httpMethod = "DELETE", code = 204)
    public ResponseEntity<JsonResponseBody> deleteById(@ApiParam @PathParam("id") Long id)
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
