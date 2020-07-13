package edu.cnm.deepdive.trailmasterservice.controller;

import edu.cnm.deepdive.trailmasterservice.model.entity.Photo;
import edu.cnm.deepdive.trailmasterservice.model.entity.Trail;
import edu.cnm.deepdive.trailmasterservice.service.PhotoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photos")
public class PhotoController {

  private final PhotoRepository photoRepository;

  public PhotoController(PhotoRepository photoRepository) {
    this.photoRepository = photoRepository;
  }

//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public Iterable<Photo> getCampsite() {
//    return photoRepository.getAllByCampsiteOrderByCreatedAsc();
//  }
//
//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public Iterable<Photo> getTrail() {
//    return photoRepository.getAllByTrailOrderByCreatedAsc();
//  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Photo post(@RequestBody Photo photo) {
    return photoRepository.save(photo);
  }

}
