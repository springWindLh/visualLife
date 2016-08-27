package lh.world.service;

import lh.world.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.Optional;

/**
 * Created by lh on 2016/8/10.
 */
public interface ArticleService {
    Article save(Article article);

    Optional<Article> findById(Long id);

    Page<Article> listByTitle(String title, int page, int size, String sortField, Sort.Direction direction);

    Page<Article> listAll(int page, int size, String sortField, Sort.Direction direction);

    void remove(Long id);
}
