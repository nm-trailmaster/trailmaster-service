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

@RestController
@RequestMapping("/campsites")
public class CampsiteController {

  private final CampsiteRepository campsiteRepository;
  private final PhotoRepository photoRepository;

  @Autowired
  public CampsiteController(
      CampsiteRepository campsiteRepository,
      PhotoRepository photoRepository) {
    this.campsiteRepository = campsiteRepository;
    this.photoRepository = photoRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public  Iterable<Campsite> get() {
    return campsiteRepository.getAllByOrderByRatingAsc();
  }

  @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Campsite get(@PathVariable long id) {

    return campsiteRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Campsite post(@RequestBody Campsite campsite) {
    return campsiteRepository.save(campsite);
  }

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
