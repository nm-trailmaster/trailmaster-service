package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.Date;

@JsonPropertyOrder({"id", "created", "updated", "text", "href"})
public interface FlatTrail {

  Long getId();

  Date getCreated();

  Date getUpdated();

  String getComment();

  URI getHref();

}
