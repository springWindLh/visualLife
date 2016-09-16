package lh.world.service;

import lh.world.domain.Comment;
import lh.world.query.support.Query;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * Created by lh on 2016/9/14.
 */
public interface CommentService {
    Comment save(Comment comment);

    Optional<Comment> findById(Long id);

    Page<Comment> listByTargetTypeAndTargetId(Comment.TargetType targetType, Long targetId, Boolean isDeleted, Query query);

    void remove(Long id);
}
