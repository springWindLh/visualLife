package lh.world.repository;

import lh.world.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lh on 2016/8/10.
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    Page<Article> queryByTitleAndDel(String title, boolean isDeleted, Pageable pageable);
}
