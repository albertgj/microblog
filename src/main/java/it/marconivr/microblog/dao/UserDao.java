package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.User;
import it.marconivr.microblog.entity.Post;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <h1>User Dao</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>
{
    @Query("SELECT u FROM Post u WHERE u.user.id = :id")
    List<Post> findPostsOfUser(Long id);
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
