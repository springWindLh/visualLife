package lh.world.service;

import lh.world.domain.Story;
import lh.world.query.support.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

/**
 * Created by lh on 2016/8/12.
 */
public interface StoryService {
    Story save(Story story);

    Optional<Story> findById(Long id);

    Page<Story> listAll(Query query);

    void remove(Long id);
}
