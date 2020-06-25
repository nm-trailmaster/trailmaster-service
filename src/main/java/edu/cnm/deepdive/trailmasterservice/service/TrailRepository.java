package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Campsite;
import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrailRepository extends JpaRepository<Trail, Long> {

  Iterable<Trail> getAllByOrderByRating();

}
