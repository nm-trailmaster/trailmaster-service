package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.Date;

@JsonPropertyOrder({"id", "created", "updated", "name", "href"})
public interface FlatImage {

  Long getId();

  Date getCreated();

  Date getUpdated();

  String getName();

  URI getHref();

}
