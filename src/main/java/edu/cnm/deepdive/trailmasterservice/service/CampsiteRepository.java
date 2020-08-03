package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Campsite;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Campsite repository.
 */
public interface CampsiteRepository extends JpaRepository<Campsite, Long> {

  /**
   * Gets all by order by rating asc.
   *
   * @return the all by order by rating asc
   */
  Iterable<Campsite> getAllByOrderByRatingAsc();

}
