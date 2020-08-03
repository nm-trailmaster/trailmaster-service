package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Trail repository.
 */
public interface TrailRepository extends JpaRepository<Trail, Long> {

  /**
   * Gets all by order by rating asc.
   *
   * @return the all by order by rating asc
   */
  Iterable<Trail> getAllByOrderByRatingAsc();


}
