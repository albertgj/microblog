package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author albert
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long>
{

}
