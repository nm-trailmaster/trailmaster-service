package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.User;
import edu.cnm.deepdive.trailmasterservice.model.entity.User.Role;
import java.security.AccessControlException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
public class UserService {

  private final UserRepository userRepository;

  /**
   * Instantiates a new User service.
   *
   * @param userRepository the user repository
   */
  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Read or create one user.
   *
   * @param oauthKey    the oauth key
   * @param displayName the display name
   * @return the user
   */
  public synchronized User readOrCreateOne(String oauthKey, String displayName) {
    return userRepository.findFirstByOauthKey(oauthKey)
        .orElseGet(() -> {
          User user = new User();
          user.setOauthKey(oauthKey);
          user.setDisplayName(displayName);
          return userRepository.save(user);
        });
  }

  /**
   * Get optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<User> get(Long id) {
    return userRepository.findById(id);
  }

  /**
   * Get optional.
   *
   * @param auth the auth
   * @return the optional
   */
  public Optional<User> get(Authentication auth) {
    return Optional.ofNullable((User) auth.getPrincipal());
  }

  /**
   * Require access.
   *
   * @param current  the current
   * @param required the required
   */
  public void requireAccess(User current, User required) {
    if (current.getId() != required.getId() && current.getRole() != Role.ADMINISTRATOR) {
      throw new AccessControlException("Access Denied");
    }
  }
}
