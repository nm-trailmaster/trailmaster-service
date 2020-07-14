package edu.cnm.deepdive.trailmasterservice.model.entity;

import java.util.Date;
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
import org.springframework.lang.NonNull;

/** This is the Entity model for Photo that came out of ERD.**/

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Photo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "photo_id", nullable = false, updatable = false)
  private Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date created;

  @UpdateTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date updated;

  @NonNull // Subject to change along with respective getter and setter.
  @Column(nullable = false)
  private String filepath;

  @ManyToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "campsite_id")
  private Campsite campsite;

  @ManyToOne(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinColumn(name = "trail_id")
  private Trail trail;

  public Long getId() {
    return id;
  }

  public Date getCreated() {
    return created;
  }

  public Date getUpdated() {
    return updated;
  }

  @NonNull
  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(@NonNull String filepath) {
    this.filepath = filepath;
  }

  public Campsite getCampsite() {
    return campsite;
  }

  public void setCampsite(Campsite campsite) {
    this.campsite = campsite;
  }

  public Trail getTrail() {
    return trail;
  }

  public void setTrail(Trail trail) {
    this.trail = trail;
  }
}
