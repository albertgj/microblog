package it.marconivr.microblog.security;

import it.marconivr.microblog.entity.ERole;
import it.marconivr.microblog.security.jwt.AuthEntryPointJwt;
import it.marconivr.microblog.security.jwt.AuthTokenFilter;
import it.marconivr.microblog.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.ws.rs.HttpMethod;

/**
 * <h1>Web Security Configuration</h1>
 * <p>This class configures the web security in spring</p>
 *
 * @author albert
 * @version 1.0.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    /**
     * <h1>AuthenticationJwtTokenFilter</h1>
     * @return AuthTokenFilter
     */
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter()
    {
        return new AuthTokenFilter();
    }

    /**
     * <h1>Configure</h1>
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * <h1>Authentication Manager</h1>
     * @return authenticationManagerBean
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    /**
     * <h1>Password Encoder</h1>
     * @return BCryptPasswordEncoder
     * <p>Password Encoder Bean that is needed to encrypt the password</p>
     */
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * <h1>Configure Method</h1>
     * @param http
     * @throws Exception
     * <ul>
     *     <li>All the posts can be seen by everyone (including users that aren't registered)</li>
     *     <li>Only admins can add new posts</li>
     *     <li>Signin and Signup are available for everyone </li>
     *     <li>All comments can be seen by everyone (including users that aren't registered) </li>
     * </ul>
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v2/posts").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v2/posts").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v2/posts").hasRole("ADMIN")
                .antMatchers("/api/v2/posts").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v2/comments").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/v2/comments").authenticated()
                .antMatchers("/api/v2/comments").permitAll()
                .antMatchers("/api/v2/users").authenticated()
                .antMatchers("/api/v2/users/**").authenticated()
                .antMatchers("/api/v2/signin", "/api/v2/signup").permitAll();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
