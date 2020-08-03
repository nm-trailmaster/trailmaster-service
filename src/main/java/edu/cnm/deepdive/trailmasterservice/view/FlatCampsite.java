package edu.cnm.deepdive.trailmasterservice.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URI;
import java.util.Date;
import org.springframework.lang.NonNull;

/**
 * The interface Flat campsite.
 */
@JsonPropertyOrder({"id", "created", "updated", "name", "href"})
public interface FlatCampsite {

  /**
   * Gets id.
   *
   * @return the id
   */
  Long getId();

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

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
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

}
