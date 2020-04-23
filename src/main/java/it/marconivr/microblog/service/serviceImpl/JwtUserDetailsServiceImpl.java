package it.marconivr.microblog.service.serviceImpl;

import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.service.PersonaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author albert
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private PersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException
    {
        Persona p = personaService.findByUsername(string);
        if (p == null)
        {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(p.getUsername(), p.getPassword(), new ArrayList<>());
    }
}
