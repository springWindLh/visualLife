package lh.world.controller;

import lh.world.controller.support.BaseController;
import lh.world.domain.Article;
import lh.world.query.ArticleQuery;
import lh.world.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        Page<Article> page = articleService.listByTitle(query.getTitle(), query.getPage(), query.getSize(), "id", Sort.Direction.DESC);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        return "/home";
    }
}
