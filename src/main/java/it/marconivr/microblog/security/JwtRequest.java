package it.marconivr.microblog.security;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author albert
 */
public class JwtRequest
{

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    public JwtRequest()
    {
    }

    public JwtRequest(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

}
