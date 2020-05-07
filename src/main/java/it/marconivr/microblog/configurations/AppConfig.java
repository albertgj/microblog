package it.marconivr.microblog.configurations;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import it.marconivr.microblog.controller.CommentController;
import it.marconivr.microblog.controller.JwtAuthenticationController;
import it.marconivr.microblog.controller.PersonaController;
import it.marconivr.microblog.controller.PostController;
import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author albert
 */
@Component
@ApplicationPath("${spring.jersey.application-path:/}")
public class AppConfig extends ResourceConfig
{

    public AppConfig()
    {
        this.register(PersonaController.class);
        this.register(PostController.class);
        this.register(CommentController.class);
        this.register(JwtAuthenticationController.class);
    }

    @PostConstruct
    public void configureSwagger()
    {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        
        config.setBasePath("/api/v2");
        config.setResourcePackage("it.marconivr.microblog.controller");
        config.setTitle("Microblog Rest Api");
        config.setContact("albertgj");
        config.setDescription("A simple blog rest api");
        config.setVersion("v2");
        config.setPrettyPrint(true);
        config.setScan(true);
        config.setLicenseUrl("https://opensource.org/licenses/MIT");
    }
}
