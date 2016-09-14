package lh.world.repository;

import lh.world.domain.Reply;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/9/14.
 */
public interface ReplyRepository extends PagingAndSortingRepository<Reply,Long> {
}
