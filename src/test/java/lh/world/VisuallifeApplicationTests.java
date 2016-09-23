package lh.world;

import lh.world.domain.Article;
import lh.world.domain.User;
import lh.world.repository.UserRepository;
import lh.world.service.ArticleService;
import lh.world.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisuallifeApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleService articleService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void Test() {
        Optional<Article> articleOptional = articleService.findById(1L);
        Optional<User> userOptional = userService.findById(1L);
        if (articleOptional.isPresent()) {
            for (int i = 30; i < 100; i++) {
                Article article = articleOptional.get();
                article.setId(null);
                article.setTitle("article" + i);
                userOptional.ifPresent(article::setUser);
                articleService.save(article);
            }
        }
    }
}
