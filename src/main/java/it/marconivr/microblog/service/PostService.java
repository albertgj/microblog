package it.marconivr.microblog.service;

import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import java.util.List;

/**
 *
 * @author albert
 */
public interface PostService
{
    public List<Post> findAll();
    public Post save(Post p);
    public void deleteById(Long id);
    public List<Comment> getCommentsOfPost(Long id);
}
