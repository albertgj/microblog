package it.marconivr.microblog.payload.response;

import lombok.*;

@AllArgsConstructor
public class MessageResponse
{
    @Getter
    @Setter
    private String message;
}
