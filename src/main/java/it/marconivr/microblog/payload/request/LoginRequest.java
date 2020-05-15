package it.marconivr.microblog.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

/**
 * <h1>Login Request</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest
{
    @Getter
    @Setter
    @NotBlank
    private String username;

    @Getter
    @Setter
    @NotBlank
    private String password;
}
