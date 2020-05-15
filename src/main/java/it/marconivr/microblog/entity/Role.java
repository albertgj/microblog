package it.marconivr.microblog.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <h1>Role Entity</h1>
 *
 * @author albert
 * @version 1.0.0
 */
@Entity
@Table(name = "roles")
public class Role implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role()
    {

    }

    public Role(ERole name)
    {
        this.name = name;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public ERole getName()
    {
        return name;
    }

    public void setName(ERole name)
    {
        this.name = name;
    }
}
