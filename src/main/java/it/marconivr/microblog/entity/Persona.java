package it.marconivr.microblog.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "persone")
public class Persona 
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
