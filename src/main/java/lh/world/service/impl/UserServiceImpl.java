package lh.world.service.impl;

import com.google.common.base.Strings;
import lh.world.domain.User;
import lh.world.repository.UserRepository;
import lh.world.service.UserService;
import lh.world.service.error.ErrorInfo;
import lh.world.util.EncrptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by lh on 2016/8/10.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        Assert.notNull(user.getName(), "user.name must not be null");
        Optional<User> userOptional = this.findByName(user.getName());
        if (userOptional.isPresent() && !user.getId().equals(userOptional.get().getId())) {
            throw new RuntimeException(ErrorInfo.USER_NAME_IS_EXIST);
        }
        Assert.notNull(user.getMobile(), "user.mobile must not be null");
        userOptional = this.findByMobile(user.getMobile());
        if (userOptional.isPresent() && !user.getId().equals(userOptional.get().getId())) {
            throw new RuntimeException(ErrorInfo.USER_MOBILE_IS_EXIST);
        }
        Assert.notNull(user.getPassword(), "user.password must not be null");
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(userRepository.findOne(id));
        }
    }

    @Override
    public Optional<User> findByName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            return Optional.empty();
        } else {
            return userRepository.findByName(name);
        }
    }

    @Override
    public Optional<User> findByMobile(String mobile) {
        if (Strings.isNullOrEmpty(mobile)) {
            return Optional.empty();
        } else {
            return userRepository.findByMobile(mobile);
        }
    }

    @Override
    public Optional<User> verifyUser(String name, String mobile, String password) {
        if (Strings.isNullOrEmpty(mobile) || Strings.isNullOrEmpty(password)) {
            return Optional.empty();
        } else {
            Optional<User> userOptional = userRepository.findFirstByNameOrMobile(name, mobile);
            if (userOptional.isPresent()) {
                boolean isRightPwd = EncrptUtil.matchesPassword(password, userOptional.get().getPassword());
                if (!isRightPwd) {
                    return Optional.empty();
                }
            }
            return userOptional;
        }
    }

}
