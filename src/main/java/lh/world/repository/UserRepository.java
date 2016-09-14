package lh.world.repository;

import lh.world.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by lh on 2016/8/10.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByMobile(String mobile);

    Optional<User> findFirstByNameOrMobile(String name, String mobile);
}
