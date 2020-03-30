package it.marconivr.microblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author albert
 */
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Basic
    @Getter
    @Setter
    private String titolo;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter
    @Setter
    private Date data;

    @Basic
    @Getter
    @Setter
    private String testo;

    @ManyToOne(targetEntity = Persona.class)
    @JoinColumn(name = "PERSONAID", nullable = false)
    @Getter
    @Setter
    private Persona persona;
}
