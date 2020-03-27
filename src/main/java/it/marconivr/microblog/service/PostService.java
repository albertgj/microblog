package it.marconivr.microblog.service;

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
    public Optional<Post> findById(Long id);
    public Post savePost(Post p);
}
