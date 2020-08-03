package edu.cnm.deepdive.trailmasterservice.model.entity;

import java.net.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.trailmasterservice.view.FlatTrail;
import edu.cnm.deepdive.trailmasterservice.view.FlatUser;
import java.net.URI;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * This is the Entity model for Trail representing columns from ERD.
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Component
@JsonIgnoreProperties(
    value = {"id", "created", "updated", "href"},
    allowGetters = true,
    ignoreUnknown = true
)
public class Trail implements FlatTrail {

  private static EntityLinks entityLinks;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "trail_id", nullable = false, updatable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "user_id", updatable = false)
  private User user;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date updated;

  @Column(nullable = false)
  private Double latitude;

  @Column(nullable = false)
  private Double longitude;

  @Column(nullable = false)
  private Integer rating;

  @NonNull
  @Column(length = 5_000,nullable = false)
  private String comment;

  @JsonSerialize(as = FlatUser.class)
  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinColumn(name = "author_id")
  private User author;
  // TODO add to erd.

  /**
   * Gets trail id.
   *
   */
  public Long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Gets date created.
   *
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Gets date trail was updated.
   *
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets trail rating.
   *
   */
  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  /**
   * Gets trail latitude.
   *
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * Sets trail latitude.
   *
   */
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets trail longitude.
   *
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * Sets trail longitude.
   *
   */
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  /**
   * Gets comments entered by users regarding special directions or a description of the trail.
   *
   */
  @NonNull
  public String getComment() {
    return comment;
  }

  /**
   * Sets user comment.
   *
   */
  public void setComment(@NonNull String comment) {
    this.comment = comment;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @PostConstruct // TODO implement in all entity classes.
  private void initHateoas() {
    //noinspection ResultOfMethodCallIgnored
    entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(
      @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") EntityLinks entityLinks) {
    Trail.entityLinks = entityLinks;
  }

  public URI getHref() {
    return (id != null) ? entityLinks.linkForItemResource(Trail.class, id).toUri() : null;
  }

}
