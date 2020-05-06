package it.marconivr.microblog.controller;

import it.marconivr.microblog.entity.Persona;
import it.marconivr.microblog.security.JwtRequest;
import it.marconivr.microblog.security.JwtResponse;
import it.marconivr.microblog.security.JwtTokenUtil;
import it.marconivr.microblog.service.PersonaService;
import it.marconivr.microblog.service.serviceImpl.JwtUserDetailsServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author albert
 */
@Component
@Path("/")
public class JwtAuthenticationController
{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsServiceImpl personaDetailsService;
    @Autowired
    private PersonaService personaService;

    @POST
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception
    {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails personaDetails = personaDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(personaDetails);
        return new JwtResponse(token);
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<?> saveUser(@RequestBody Persona persona) throws Exception
    {
        return ResponseEntity.ok(personaService.save(persona));
    }

    private void authenticate(String username, String password) throws Exception
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e)
        {
            throw new Exception("NON FUNZIONA", e);
        }
    }
}
