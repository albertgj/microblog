package it.marconivr.microblog.entity;



import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Entity
@Table(name = "posts")
public class Post 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;
	
	@Basic
	@Getter @Setter
	private String titolo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Getter @Setter
	private Date data;
	
	@Basic
	@Getter @Setter
	private String commento;
	
	@ManyToOne(targetEntity = Persona.class)
	@JoinColumn(name = "PERSONAID", nullable = false)
	@Getter @Setter
	private Persona persona;
}
