package it.marconivr.microblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.PostService;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * <h1>Post Controller</h1>
 * <p>This controller handles posts</p>
 * 
 * @author albert
 * @version 1.0.0
 */
@Component
@Path("/posts")
@Api("Post Controller")
public class PostController
{
    
    @Autowired
    private PostService postService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> findAll()
    {
        
        return ResponseEntity.status(HttpStatus.OK)
                .body(new JsonResponseBody(HttpStatus.OK.value(), postService.findAll()));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> save(@ApiParam Post p)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new JsonResponseBody(HttpStatus.CREATED.value(), postService.save(p)));
    }
    
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> deleteById(@ApiParam @PathParam("id") Long id)
    {
        postService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new JsonResponseBody(HttpStatus.NO_CONTENT.value(), null));
    }
    
    @GET
    @Path("/{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> getCommentsOfPost(@ApiParam @PathParam("id") Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), postService.getCommentsOfPost(id)));
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
