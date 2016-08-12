package lh.world.service;

import lh.world.domain.User;

import java.util.Optional;

/**
 * Created by lh on 2016/8/10.
 */
public interface UserService {
    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    Optional<User> findByMobile(String mobile);

    Optional<User> verifyUser(String name, String mobile, String password);
}
