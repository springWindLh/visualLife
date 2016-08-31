package lh.world.service.impl;

import com.google.common.base.Strings;
import lh.world.domain.Article;
import lh.world.domain.User;
import lh.world.query.support.Query;
import lh.world.repository.ArticleRepository;
import lh.world.service.ArticleService;
import lh.world.service.support.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<Article> listByTitle(String title, Query query) {
        if (Strings.isNullOrEmpty(title)) {
            return this.listAll(query);
        } else {
            return articleRepository.queryByDelAndTitleLike(false, ServiceUtil.addPercent(title), query.getPageable());
        }
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

    @Override
    public Page<Article> listAll(Query query) {
        return articleRepository.findAll(query.getPageable());
    }

    @Override
    public Page<Article> listByUser(User user, Query query, boolean isDeleted) {
        return articleRepository.queryByDelAndUser(isDeleted, user, query.getPageable());
    }
}
