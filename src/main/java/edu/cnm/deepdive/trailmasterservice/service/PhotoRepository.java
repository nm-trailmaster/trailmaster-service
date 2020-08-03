package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Campsite;
import edu.cnm.deepdive.trailmasterservice.model.entity.Photo;
import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Photo repository.
 */
//Unsure how the upload process works and what it is needed
public interface PhotoRepository extends JpaRepository<Photo, Long> {

  /**
   * Gets all by campsite order by created asc.
   *
   * @param campsite the campsite
   * @return the all by campsite order by created asc
   */
  Iterable<Photo> getAllByCampsiteOrderByCreatedAsc(Campsite campsite);

  /**
   * Gets all by trail order by created asc.
   *
   * @param trail the trail
   * @return the all by trail order by created asc
   */
  Iterable<Photo> getAllByTrailOrderByCreatedAsc(Trail trail);

}
