package edu.cnm.deepdive.trailmasterservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableWebSecurity
@EnableResourceServer
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class TrailmasterServiceApplication extends ResourceServerConfigurerAdapter {

  @Value("${oauth.clientId}")
  private String clientId;
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class TrailmasterServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrailmasterServiceApplication.class, args);
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId(clientId);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/trails").hasRole("USER")
        .antMatchers(HttpMethod.PUT, "/trails/**").hasRole("USER")
        .antMatchers(HttpMethod.DELETE, "/trails/**").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/campsite").hasRole("USER")
        .antMatchers(HttpMethod.PUT, "/campsite/**").hasRole("USER")
        .antMatchers(HttpMethod.DELETE, "/campsite/**").hasRole("USER")
        .anyRequest().permitAll();
  }

}
