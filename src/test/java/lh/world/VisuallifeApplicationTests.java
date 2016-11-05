package lh.world;

import lh.world.base.domain.Article;
import lh.world.base.domain.Story;
import lh.world.base.domain.User;
import lh.world.base.repository.UserRepository;
import lh.world.base.service.ArticleService;
import lh.world.base.service.StoryService;
import lh.world.base.service.UserService;
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
    @Autowired
    private StoryService storyService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void Test() {
//        Optional<Story> storyOptional = storyService.findById(1L);
//        Optional<User> userOptional = userService.findById(1L);
//        if (storyOptional.isPresent()) {
//            for (int i = 4; i < 100; i++) {
//                Story story = storyOptional.get();
//                story.setId(null);
//                story.setDescription("story" + i);
//                userOptional.ifPresent(story::setUser);
//                storyService.save(story);
//            }
//        }

//        Optional<Article> articleOptional = articleService.findById(1L);
//        Optional<User> userOptional = userService.findById(1L);
//        if (articleOptional.isPresent()) {
//            for (int i = 4; i < 100; i++) {
//                Article article = articleOptional.get();
//                article.setId(null);
//                article.setContent("文章内容" + i);
//                userOptional.ifPresent(article::setUser);
//                articleService.save(article);
//            }
//        }
    }
}
