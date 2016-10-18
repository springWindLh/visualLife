package lh.world.web.controller;

import lh.world.web.controller.support.AjaxResponse;
import lh.world.web.controller.support.BaseController;
import lh.world.domain.Article;
import lh.world.web.query.ArticleQuery;
import lh.world.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lh on 2016/8/26.
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(ArticleQuery query, Model model) {
        return "/home";
    }

    @RequestMapping(value = "/article/list", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse articleList(ArticleQuery query) {
        Page<Article> page = articleService.listByTitle(query.getTitle(), query);
        return AjaxResponse.ok().data(page);
    }
}
