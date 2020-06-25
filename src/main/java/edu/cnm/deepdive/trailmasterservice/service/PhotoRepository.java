package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

//Unsure how the upload process works and what it is needed
public interface PhotoRepository extends JpaRepository<Photo, Long> {

  Iterable<Photo> getAllByOrderByTextAsc();

  Iterable<Photo> getAllByCampsiteOrderByCreatedAsc();

  Iterable<Photo> getAllByTrailOrderByCreatedAsc();

}