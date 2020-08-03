package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.User;
import edu.cnm.deepdive.trailmasterservice.model.entity.User.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Find first by oauth key optional.
   *
   * @param oauthKey the oauth key
   * @return the optional
   */
  Optional<User> findFirstByOauthKey(String oauthKey);

  /**
   * Gets all by role order by display name asc.
   *
   * @param role the role
   * @return the all by role order by display name asc
   */
  Iterable<User> getAllByRoleOrderByDisplayNameAsc(Role role);
}
