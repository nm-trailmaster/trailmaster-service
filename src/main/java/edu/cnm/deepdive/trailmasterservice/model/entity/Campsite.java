package edu.cnm.deepdive.trailmasterservice.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

/** This is the Entity model for Campsite that came out of ERD.**/


@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Campsite {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "campsite_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, updatable = false)
  private Date created;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date updated;

  @Column(nullable = false)
  private double latitude;

  @Column(nullable = false)
  private double longitude;

  @Column(nullable = false)
  private int rating;

  @NonNull
  @Column(length = 5_000, nullable = false)
  private String comment;

  public Long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public Date getUpdated() {
    return updated;
  }

  public int getRating() {
    return rating;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @NonNull
  public String getComment() {
    return comment;
  }

  public void setComment(@NonNull String comment) {
    this.comment = comment;
  }
}
