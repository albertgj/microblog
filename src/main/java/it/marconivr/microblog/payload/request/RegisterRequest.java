package it.marconivr.microblog.payload.request;

import lombok.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * <h1>Registration Request</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest
{
    @NotBlank
    @Getter
    @Setter
    private String username;

    @NotBlank
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Set<String> role;
}
