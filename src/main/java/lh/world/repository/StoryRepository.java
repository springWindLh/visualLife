package lh.world.repository;

import lh.world.domain.Story;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/8/12.
 */
public interface StoryRepository extends PagingAndSortingRepository<Story, Long> {
}
