package edu.cnm.deepdive.trailmasterservice.controller;

import edu.cnm.deepdive.trailmasterservice.model.entity.Campsite;
import edu.cnm.deepdive.trailmasterservice.service.CampsiteRepository;
import edu.cnm.deepdive.trailmasterservice.service.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

 // @GetMapping(value = "/{id:\\d+}/photo", produces = MediaType.APPLICATION_JSON_VALUE)
 // public Iterable<Photo> getPhoto(@PathVariable long id) {
 //   return campsiteRepository.findById(id)
 //       .map(tag -> photoRepository.getAllByOrderByTextAsc())
 //           .orElseThrow(() -> new NoSuchElementException());
 // }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Campsite post(@RequestBody Campsite campsite) {
    return campsiteRepository.save(campsite);
  }


}
