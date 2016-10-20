package lh.world.web.controller;

import lh.world.base.domain.Article;
import lh.world.base.domain.Story;
import lh.world.base.query.support.Query;
import lh.world.base.service.ArticleService;
import lh.world.base.service.StoryService;
import lh.world.web.controller.support.AjaxResponse;
import lh.world.web.controller.support.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lh on 2016/9/4.
 */
@Controller
@RequestMapping("/myHome")
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
        return AjaxResponse.ok().data(page);
    }

    @RequestMapping(value = "/story", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse story(Query query) {
        Page<Story> page = storyService.listByUser(getCurrentUser(), query, false);
        return AjaxResponse.ok().data(page);
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse userInfo() {
        return AjaxResponse.ok().data(getCurrentUser());
    }
}
