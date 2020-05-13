package it.marconivr.microblog.configurations;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import it.marconivr.microblog.controller.CommentController;
import it.marconivr.microblog.controller.AuthController;
import it.marconivr.microblog.controller.UserController;
import it.marconivr.microblog.controller.PostController;
import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * <h1>Application Configuration Class</h1>
 * <p>This class is needed for configuring jersey and swagger</p>
 *
 * @author albert
 */
@Component
@ApplicationPath("${spring.jersey.application-path:/}")
public class AppConfig extends ResourceConfig
{

    public AppConfig()
    {
        this.register(UserController.class);
        this.register(PostController.class);
        this.register(CommentController.class);
        this.register(AuthController.class);
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
