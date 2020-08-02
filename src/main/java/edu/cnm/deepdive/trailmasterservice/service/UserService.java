package edu.cnm.deepdive.trailmasterservice.service;

import edu.cnm.deepdive.trailmasterservice.model.entity.User;
import edu.cnm.deepdive.trailmasterservice.model.entity.User.Role;
import java.security.AccessControlException;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.graalvm.compiler.lir.LIRInstruction.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public synchronized User readOrCreateOne(String oauthKey, String displayName) {
    return userRepository.findFirstByOauthKey(oauthKey)
        .orElseGet(() -> {
          User user = new User();
          user.setOauthKey(oauthKey);
          user.setOauthKey(displayName);
          return userRepository.save(user);
        });
  }

  public Optional<User> get(Long id) {
    return userRepository.findById(id);
  }

  public Optional<User> get(Authentication auth) {
    return Optional.ofNullable((User) auth.getPrincipal());
  }

  public void requireAccess(User current, User required) {
    if (current.getId() != required.getId() && current.getRole() != Role.ADMINISTRATOR) {
      throw new AccessControlException("Access Denied");
    }
  }
}
