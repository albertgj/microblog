package it.marconivr.microblog.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.marconivr.microblog.entity.Post;
import it.marconivr.microblog.entity.dao.PostDao;
import it.marconivr.microblog.service.serviceImpl.PostServiceImpl;

@Component
@Path("/posts")
public class PostController
{
    @Autowired
    private PostServiceImpl postServiceImpl;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Post newPost(Post p)
    {
        return postServiceImpl.savePost(p);
    }
}
