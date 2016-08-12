package lh.world.service.impl;

import lh.world.domain.Article;
import lh.world.repository.ArticleRepository;
import lh.world.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by lh on 2016/8/11.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(articleRepository.findOne(id));
        }
    }

    @Override
    public Page<Article> listByTitle(String title, int page, int size, String sortField, Sort.Direction direction) {
        PageRequest request = new PageRequest(page, size, new Sort(direction, sortField));
        return articleRepository.queryByTitleAndDel(title, false, request);
    }

    @Override
    public void remove(Long id) {
        if (id != null) {
            Optional<Article> articleOptional = this.findById(id);
            if (articleOptional.isPresent()) {
                Article article = articleOptional.get();
                article.setDel(true);
                this.save(article);
            }
        }
    }
}
