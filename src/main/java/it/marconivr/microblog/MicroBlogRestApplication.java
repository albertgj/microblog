package it.marconivr.microblog;

import it.marconivr.microblog.dao.RoleDao;
import it.marconivr.microblog.entity.ERole;
import it.marconivr.microblog.entity.Role;
import it.marconivr.microblog.entity.User;
import it.marconivr.microblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashSet;
import java.util.Set;

/**
 * @author albert
 *
 */
@SpringBootApplication
public class MicroBlogRestApplication implements CommandLineRunner
{
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserService userService;

    public static void main(String[] args)
    {
        SpringApplication.run(MicroBlogRestApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception
    {

        if(!(roleDao.existsRoleByName(ERole.ROLE_USER) && roleDao.existsRoleByName(ERole.ROLE_ADMIN)))
        {
            roleDao.save(new Role(ERole.ROLE_ADMIN));
            roleDao.save(new Role(ERole.ROLE_USER));
        }

        if(!(userService.existsByUsername("admin1") && userService.existsByUsername("admin2")))
        {
            Set<Role> roles = new HashSet<>();
            Role adminRole = roleDao.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            User admin1 = new User();
            admin1.setUsername("admin1");
            admin1.setPassword("root");
            admin1.setRoles(roles);

            User admin2 = new User();
            admin2.setUsername("admin2");
            admin2.setPassword("root");
            admin2.setRoles(roles);

            userService.save(admin1);
            userService.save(admin2);
        }
    }
}
