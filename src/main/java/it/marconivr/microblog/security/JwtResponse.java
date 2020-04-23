package it.marconivr.microblog.security;

import lombok.Getter;

/**
 *
 * @author albert
 */
public class JwtResponse
{


    @Getter
    private final String jwttoken;

    public JwtResponse(String jwttoken)
    {
        this.jwttoken = jwttoken;
    }
}
