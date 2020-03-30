package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author albert
 */
@Repository
public interface PostDao extends JpaRepository<Post, Long>
{
    
}
