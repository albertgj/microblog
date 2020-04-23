package it.marconivr.microblog.controller;

import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.PostService;
import java.util.List;
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
 *
 * @author albert
 */
@Component
@Path("/posts")
public class PostController
{
    
    @Autowired
    private PostService postService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> findAll()
    {
        //return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), postService.findAll()));
        return postService.findAll();
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> save(Post p)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new JsonResponseBody(HttpStatus.CREATED.value(), postService.save(p)));
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Long id)
    {
        postService.deleteById(id);
        //return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new PostController.JsonResponseBody(HttpStatus.NO_CONTENT.value(), null));
    }
    
    @GET
    @Path("/commenti/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getCommentsOfPost(@PathParam("id") Long id)
    {
        return postService.getCommentsOfPost(id);
        
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
