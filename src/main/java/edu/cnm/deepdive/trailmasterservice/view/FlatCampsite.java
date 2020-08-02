package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.Date;
import org.springframework.lang.NonNull;

@JsonPropertyOrder({"id", "created", "updated", "name", "href"})
public interface FlatCampsite {

  Long getId();

  String getName();

  Date getCreated();

  Date getUpdated();

  URI getHref();

}
