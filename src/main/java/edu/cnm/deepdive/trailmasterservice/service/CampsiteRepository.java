package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.Campsite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampsiteRepository extends JpaRepository<Campsite, Long> {

  Iterable<Campsite> getAllByOrderByRatingAsc();

}
