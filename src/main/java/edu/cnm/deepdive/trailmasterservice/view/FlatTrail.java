package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.Date;

/**
 * The interface Flat trail.
 */
@JsonPropertyOrder({"id", "created", "updated", "text", "href"})
public interface FlatTrail {

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
   * Gets comment.
   *
   * @return the comment
   */
  String getComment();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

}
