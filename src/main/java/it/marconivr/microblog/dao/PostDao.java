package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.Comment;
import it.marconivr.microblog.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <h1>Post Dao</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Repository
public interface PostDao extends JpaRepository<Post, Long>
{
    @Query("SELECT u FROM Comment u WHERE u.post.id = :id")
    public List<Comment> findCommentsOfPost(Long id);
}
