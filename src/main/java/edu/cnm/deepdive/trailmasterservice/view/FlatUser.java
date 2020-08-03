package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.cnm.deepdive.trailmasterservice.model.entity.User.Role;
import java.net.URI;
import java.util.Date;

/**
 * The interface Flat user.
 */
@JsonPropertyOrder({"id", "created", "updated", "displayName", "role", "href"})
public interface FlatUser {

  /**
   * Gets id.
   *
   * @return the id
   */
  Long getId();

  /**
   * Gets created.
   *
   * @return the created
   */
  Date getCreated();

  /**
   * Gets updated.
   *
   * @return the updated
   */
  Date getUpdated();

  /**
   * Gets display name.
   *
   * @return the display name
   */
  String getDisplayName();

  /**
   * Gets role.
   *
   * @return the role
   */
  Role getRole();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

}
