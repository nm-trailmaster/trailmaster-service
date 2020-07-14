package edu.cnm.deepdive.trailmasterservice.controller;

import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import edu.cnm.deepdive.trailmasterservice.service.PhotoRepository;
import edu.cnm.deepdive.trailmasterservice.service.TrailRepository;
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
@RequestMapping("/trails")
public class TrailController {

  private final TrailRepository trailRepository;

  @Autowired
  public TrailController(TrailRepository trailRepository) {
    this.trailRepository = trailRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Trail> get() { return trailRepository.getAllByOrderByRatingAsc();
  }

  @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Trail get(@PathVariable long id) {

    return trailRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Trail post(@RequestBody Trail trail) {
    return trailRepository.save(trail);
  }

  @PutMapping(value = "/{id:\\d+}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Trail putTrail(@PathVariable long id, @RequestBody Trail trail) {
     trail = get(id);
    if (trail != null && trail.getId() != null) {
      trail = trailRepository.findById(trail.getId()).orElseThrow(NoSuchElementException::new);
    }
    return trailRepository.save(trail);
  }
}
