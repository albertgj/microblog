package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>Comment Dao</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long>
{

}
