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
    Long count();
    List<Comment> findAll();
    Comment save(Comment c);
    void delete(Long id);
}
