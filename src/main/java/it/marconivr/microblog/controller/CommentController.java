package it.marconivr.microblog.controller;

import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.service.CommentService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
@Path("/commenti")
public class CommentController
{

    @Autowired
    private CommentService commentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> findAll()
    {
        return commentService.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<JsonResponseBody> save(Comment c)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentController.JsonResponseBody(HttpStatus.CREATED.value(), commentService.save(c)));
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
