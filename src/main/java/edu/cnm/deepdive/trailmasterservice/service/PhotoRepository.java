package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

  Iterable<Photo> getAllByOrderByTextAsc();

  Iterable<Photo> getAllByCampsiteOrderByCreatedAsc();

  Iterable<Photo> getAllByTrailOrderByCreatedAsc();

}
