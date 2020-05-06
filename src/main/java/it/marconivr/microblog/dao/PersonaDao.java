package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.entity.Post;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author albert
 */
@Repository
public interface PersonaDao extends JpaRepository<Persona, Long>
{
    @Query("SELECT u FROM Post u WHERE u.persona.id = :id")
    public List<Post> findPostsOfUser(Long id);

    public Persona findByUsername(String username);
}
