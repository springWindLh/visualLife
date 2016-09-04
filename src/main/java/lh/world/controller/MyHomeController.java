package lh.world.controller;

import lh.world.controller.support.AjaxResponse;
import lh.world.controller.support.BaseController;
import lh.world.domain.Article;
import lh.world.domain.Story;
import lh.world.domain.User;
import lh.world.query.support.Query;
import lh.world.service.ArticleService;
import lh.world.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lh on 2016/9/4.
 */
@Controller
@RequestMapping("myHome")
public class MyHomeController extends BaseController {
    @Autowired
    ArticleService articleService;
    @Autowired
    StoryService storyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String myHome() {
        return "/myHome";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse article(Query query) {
        Page<Article> page = articleService.listByUser(getCurrentUser(), query, false);
        return AjaxResponse.ok().data(page.getContent());
    }

    @RequestMapping(value = "/story", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse story(Query query) {
        Page<Story> page = storyService.listByUser(getCurrentUser(), query, false);
        return AjaxResponse.ok().data(page.getContent());
    }
}
