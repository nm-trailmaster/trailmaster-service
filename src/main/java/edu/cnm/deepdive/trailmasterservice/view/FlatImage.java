package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.Date;

/**
 * The interface Flat image.
 */
@JsonPropertyOrder({"id", "created", "updated", "name", "href"})
public interface FlatImage {

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
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

}
