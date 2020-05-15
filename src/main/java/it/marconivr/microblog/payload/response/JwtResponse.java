package it.marconivr.microblog.payload.response;

import lombok.*;

@NoArgsConstructor
public class JwtResponse
{
    @Getter
    @Setter
    private String token;


    public JwtResponse(String accessToken)
    {
        this.token = accessToken;
    }
}
