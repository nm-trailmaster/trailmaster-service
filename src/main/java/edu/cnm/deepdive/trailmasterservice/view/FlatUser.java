package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.trailmasterservice.model.entity.User.Role;
import java.net.URI;
import java.util.Date;

@JsonPropertyOrder({"id", "created", "updated", "displayName", "role", "href"})
public interface FlatUser {

  Long getId();

  Date getCreated();

  Date getUpdated();

  String getDisplayName();

  Role getRole();

  URI getHref();

}
