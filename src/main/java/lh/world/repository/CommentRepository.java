package lh.world.repository;

import lh.world.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/9/14.
 */
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
//    Page<Comment> queryByTargetType
}
