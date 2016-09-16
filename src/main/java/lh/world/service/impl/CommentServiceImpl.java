package lh.world.service.impl;

import lh.world.domain.Comment;
import lh.world.query.support.Query;
import lh.world.repository.CommentRepository;
import lh.world.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by lh on 2016/9/16.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(commentRepository.findOne(id));
        }
    }

    @Override
    public Page<Comment> listByTargetTypeAndTargetId(Comment.TargetType targetType, Long targetId, Boolean isDeleted, Query query) {
        return commentRepository.queryByTargetTypeAndTargetIdAndDel(targetType, targetId, isDeleted, query.getPageable());
    }

    @Override
    public void remove(Long id) {
        if (id != null) {
            Optional<Comment> commentOptional = this.findById(id);
            if (commentOptional.isPresent()) {
                Comment comment = commentOptional.get();
                comment.setDel(true);
                this.save(comment);
            }
        }
    }
}
