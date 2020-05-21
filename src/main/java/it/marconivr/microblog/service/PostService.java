package it.marconivr.microblog.service;

import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import java.util.List;
import java.util.Optional;

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
    public Optional<Post> findById(Long id);
}