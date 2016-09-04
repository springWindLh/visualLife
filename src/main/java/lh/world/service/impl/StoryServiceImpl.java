package lh.world.service.impl;

import lh.world.domain.Story;
import lh.world.domain.User;
import lh.world.query.support.Query;
import lh.world.repository.StoryRepository;
import lh.world.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by lh on 2016/8/12.
 */
@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoryRepository storyRepository;

    @Override
    public Story save(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public Optional<Story> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(storyRepository.findOne(id));
        }
    }

    @Override
    public Page<Story> listAll(Query query) {
        return storyRepository.findAll(query.getPageable());
    }

    @Override
    public Page<Story> listByUser(User user, Query query, boolean isDeleted) {
        return storyRepository.queryByDelAndUser(isDeleted, user, query.getPageable());
    }

    @Override
    public void remove(Long id) {
        if (id != null) {
            Optional<Story> storyOptional = this.findById(id);
            if (storyOptional.isPresent()) {
                Story story = storyOptional.get();
                story.setDel(true);
                this.save(story);
            }
        }
    }
}
