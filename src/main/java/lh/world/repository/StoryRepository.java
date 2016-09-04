package lh.world.repository;

import lh.world.domain.Story;
import lh.world.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/8/12.
 */
public interface StoryRepository extends PagingAndSortingRepository<Story, Long> {
    Page<Story> queryByDelAndUser(boolean isDeleted, User user, Pageable pageable);
}
