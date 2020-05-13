package it.marconivr.microblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;

/**
 * <h1>Comment entity </h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Comment")
public class Comment implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter
    @Setter
    private Date data;

    @Basic
    @Getter
    @Setter
    private String testo;

    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "POSTID", nullable = false)
    @Getter
    @Setter
    private Post post;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USERID", nullable = false)
    @Getter
    @Setter
    private User user;
}
