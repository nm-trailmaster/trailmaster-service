package edu.cnm.deepdive.trailmasterservice.controller;

import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import edu.cnm.deepdive.trailmasterservice.service.PhotoRepository;
import edu.cnm.deepdive.trailmasterservice.service.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trails")
public class TrailController {

  private final TrailRepository trailRepository;
  private final PhotoRepository photoRepository;

  @Autowired
  public TrailController(TrailRepository trailRepository,
      PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
    this.trailRepository = trailRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Trail> get() { return trailRepository.getAllByOrderByRating();
  }

//  @GetMapping(value = "/{id:\\d+}/trail", produces = MediaType.APPLICATION_JSON_VALUE)
//  public Iterable<Photo> getPhoto(@PathVariable long id) {
//    return trailRepository.findById(id)
//        .map(trail -> photoRepository.getAllByTrailOrderByCreatedAsc(trail))
//        .orElseThrow(() -> new NoSuchElementException());
//  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Trail post(@RequestBody Trail trail) {
    return trailRepository.save(trail);
  }

}
