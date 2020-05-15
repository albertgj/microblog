package it.marconivr.microblog.dao;

import it.marconivr.microblog.entity.ERole;
import it.marconivr.microblog.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>Role Dao</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Long>
{
    boolean existsRoleByName(ERole name);
    Optional<Role> findByName(ERole name);
}
