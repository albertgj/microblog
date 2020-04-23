package it.marconivr.microblog.service;

import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import java.util.List;

/**
 *
 * @author albert
 */
public interface CommentService
{
    public Long count();
    public List<Comment> findAll();
    public Comment save(Comment c);
}
