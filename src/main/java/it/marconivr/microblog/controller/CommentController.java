package it.marconivr.microblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.service.CommentService;

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
 * <h1>Comment Controller</h1>
 * <p>This controller handles comments</p>
 * @author albert
 */
@Component
@Path("/comments")
@Api("Comment Controller")
public class CommentController
{

    @Autowired
    private CommentService commentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retrives all comments", httpMethod = "GET", code = 200, produces = "application/json")
    public ResponseEntity<JsonResponseBody> findAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), commentService.findAll()));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Saves a comment", httpMethod = "POST", code = 201, consumes = "application/json", produces = "application/json")
    public ResponseEntity<JsonResponseBody> save(@ApiParam Comment c)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new JsonResponseBody(HttpStatus.CREATED.value(), commentService.save(c)));
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value = "Deletes a comment", httpMethod = "DELETE", code = 204)
    public ResponseEntity<JsonResponseBody> delete(@PathParam("id") Long id)
    {
        commentService.delete(id);
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
