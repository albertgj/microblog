package it.marconivr.microblog.service;

import it.marconivr.microblog.entity.User;
import it.marconivr.microblog.entity.Post;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author albert
 */
public interface UserService
{
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    User save(User p);
    void deleteById(Long id);
    List<Post> getPostsOfUser(Long id);
}
