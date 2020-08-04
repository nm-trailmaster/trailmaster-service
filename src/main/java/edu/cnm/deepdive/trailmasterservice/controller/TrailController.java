package edu.cnm.deepdive.trailmasterservice.controller;

import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import edu.cnm.deepdive.trailmasterservice.service.TrailRepository;
import edu.cnm.deepdive.trailmasterservice.service.UserService;
import java.security.AccessControlException;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Trail controller.
 */
@RestController
@RequestMapping("/trails")
@ExposesResourceFor(Trail.class)
public class TrailController {

  private final TrailRepository trailRepository;
  private final UserService userService;

  /**
   * Instantiates a new Trail controller.
   *
   * @param trailRepository the trail repository
   * @param userService     the user service
   */
  @Autowired
  public TrailController(TrailRepository trailRepository,
      UserService userService) {
    this.trailRepository = trailRepository;
    this.userService = userService;
  }

  /**
   * Gets trail order by raring asc.
   *
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Trail> get() {
    return trailRepository.getAllByOrderByRatingAsc();
  }

  /**
   * Get trail using id else throws exception.
   *
   * @param id the id
   * @return the trail
   */
  @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Trail get(@PathVariable long id) {

    return trailRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  /**
   * Allows trail to be created (Posted) and saved.
   *
   * @param trail the trail
   * @param auth  the auth
   * @return the response entity
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Trail> post(@RequestBody Trail trail, Authentication auth) {
    return userService.get(auth)
        .map((user) -> {
          trail.setAuthor(user);
          trailRepository.save(trail);
          return ResponseEntity.created(trail.getHref()).body(trail);
        })
        .orElseThrow(NoSuchElementException::new);
  }

  /**
   * Put trail trail.
   *
   * @param id    the id
   * @param trail the trail
   * @param auth  the auth
   * @return the trail
   */
  @PutMapping(value = "/{id:\\d+}",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Trail putTrail(@PathVariable long id, @RequestBody Trail trail, Authentication auth) {
    return userService.get(auth)
        .flatMap((user) -> trailRepository.findById(id))
        .map((existing) -> {
          if (trail.getComment() != null) {
            existing.setComment(trail.getComment());
          }
          if (trail.getLatitude() != null) {
            existing.setLatitude(trail.getLatitude());
          }
          if (trail.getLongitude() != null) {
            existing.setLongitude(trail.getLongitude());
          }
          return trailRepository.save(existing);
        })
        .orElseThrow(NoSuchElementException::new);
  }

  /**
   * Delete.
   *
   * @param id   the id
   * @param auth the auth
   */
  @DeleteMapping(value = "/{id:\\d+")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable long id, Authentication auth) {
    userService.get(auth)
        .flatMap((user) -> trailRepository.findById(id))
        .map((existing) -> {
          trailRepository.delete(existing);
          return null;
        })
        .orElseThrow(NoSuchElementException::new);
  }


  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

  // TODO Define more specfic expection handlers
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(Exception.class)
//  public void badRequest() {
//  }
}
