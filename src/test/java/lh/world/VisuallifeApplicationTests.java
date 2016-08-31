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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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
    public void addUser() {
//        User user = new User();
//        user.setName("name1");
//        user.setMobile("18328388471");
//        user.setPassword("123456");
//        userService.save(user);
//        Optional<User> user1 = userRepository.findFirstByNameOrMobile("na", "18328388471");

//        Article article = new Article();
//        article.setTitle("article1");
//        article.setSummarize("summarize1");
//        article.setWeight(0);
//        article.setVote(0);
//        articleService.save(article);
//        Page<Article> articles = articleService.listByTitle("", 0, 10, "id", Sort.Direction.DESC);
//        System.out.println(articles.getTotalElements());
    }
}
