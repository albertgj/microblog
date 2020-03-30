package it.marconivr.microblog.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author albert
 */

@Entity
@Table(name = "persona")
@AllArgsConstructor @NoArgsConstructor
public class Persona implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    
    @Basic
    @Getter
    @Setter
    private String username;
}
