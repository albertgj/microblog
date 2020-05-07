package it.marconivr.microblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author albert
 */
@Entity
@Table(name = "persona")
@ApiModel(value = "Persona")
@AllArgsConstructor
@NoArgsConstructor
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

    @Basic
    @Getter
    @Setter
    private String password;
}
