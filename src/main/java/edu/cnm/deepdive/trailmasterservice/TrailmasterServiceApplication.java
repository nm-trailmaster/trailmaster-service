package edu.cnm.deepdive.trailmasterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class TrailmasterServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrailmasterServiceApplication.class, args);
  }

}
