package edu.cnm.deepdive.trailmasterservice.controller;

import edu.cnm.deepdive.trailmasterservice.model.entity.Campsite;

import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import edu.cnm.deepdive.trailmasterservice.service.CampsiteRepository;
import edu.cnm.deepdive.trailmasterservice.service.PhotoRepository;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controls the server output for Campsite. It uses basic CRUD functions.
 */
@RestController
@RequestMapping("/campsites")
public class CampsiteController {

  private final CampsiteRepository campsiteRepository;
  private final PhotoRepository photoRepository;

  /**
   * Creates a new Campsite controller.
   *
   * @param campsiteRepository the campsite repository
   * @param photoRepository    the photo repository
   */
  @Autowired
  public CampsiteController(
      CampsiteRepository campsiteRepository,
      PhotoRepository photoRepository) {
    this.campsiteRepository = campsiteRepository;
    this.photoRepository = photoRepository;
  }

  /**
   * Get campsite order by rating asc.
   *
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public  Iterable<Campsite> get() {
    return campsiteRepository.getAllByOrderByRatingAsc();
  }

  /**
   * Get campsite using id, else throws exception.
   */
  @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Campsite get(@PathVariable long id) {

    return campsiteRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  /**
   * Allows campsite to be created (Posted) and saved.
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Campsite post(@RequestBody Campsite campsite) {
    return campsiteRepository.save(campsite);
  }

  /**
   * Allows campsite posts to be updated.
   *
  */
  @PutMapping(value = "/{id:\\d+}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Campsite putCampsite(@PathVariable long id, @RequestBody Campsite campsite) {
    campsite = get(id);
    if (campsite != null && campsite.getId() != null) {
      campsite = campsiteRepository.findById(campsite.getId()).orElseThrow(NoSuchElementException::new);
    }
    return campsiteRepository.save(campsite);
  }
}
