package edu.cnm.deepdive.trailmasterservice.model.entity;

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
 * The type Trail.
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

  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.REFRESH})
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

  @Column()
  private String name;

  @Column(nullable = false)
  private Double latitude;

  @Column(nullable = false)
  private Double longitude;

  @Column(nullable = false)
  private Integer rating;

  @NonNull
  @Column(length = 5_000, nullable = false)
  private String comment;

  @JsonSerialize(as = FlatUser.class)
  @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.REFRESH})
  @JoinColumn(name = "author_id")
  private User author;
  // TODO add to erd.

  public Long getId() {
    return id;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user the user
   */
  public void setUser(User user) {
    this.user = user;
  }

  public Date getCreated() {
    return created;
  }

  public Date getUpdated() {
    return updated;
  }

  /**
   * Gets rating.
   *
   * @return the rating
   */
  public Integer getRating() {
    return rating;
  }

  /**
   * Sets rating.
   *
   * @param rating the rating
   */
  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets latitude.
   *
   * @return the latitude
   */



  public Double getLatitude() {
    return latitude;
  }

  /**
   * Sets latitude.
   *
   * @param latitude the latitude
   */
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * Sets longitude.
   *
   * @param longitude the longitude
   */
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @NonNull
  public String getComment() {
    return comment;
  }

  /**
   * Sets comment.
   *
   * @param comment the comment
   */
  public void setComment(@NonNull String comment) {
    this.comment = comment;
  }

  /**
   * Gets author.
   *
   * @return the author
   */
  public User getAuthor() {
    return author;
  }

  /**
   * Sets author.
   *
   * @param author the author
   */
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
