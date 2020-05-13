package it.marconivr.microblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

/**
 * <h1>Post Entity</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Entity
@Table(name = "post")
@ApiModel(value = "Post")
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
    private String text;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USERID", nullable = false)
    @Getter
    @Setter
    private User user;
}
