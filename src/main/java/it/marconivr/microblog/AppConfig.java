package it.marconivr.microblog;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import it.marconivr.microblog.controller.PersonaController;
import it.marconivr.microblog.controller.PostController;

@Component
@ApplicationPath("${spring.jersey.application-path:/}")
public class AppConfig extends ResourceConfig
{
	public AppConfig()
	{
		this.register(PersonaController.class);
		this.register(PostController.class);
	}
}
