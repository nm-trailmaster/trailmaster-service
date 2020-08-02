package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.User;
import edu.cnm.deepdive.trailmasterservice.model.entity.User.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findFirstByOauthKey(String oauthKey);

  Iterable<User> getAllByRoleOrderByDisplayNameAsc(Role role);
}
