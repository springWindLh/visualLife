package lh.world.controller;

import lh.world.controller.support.BaseController;
import lh.world.form.ArticleForm;
import lh.world.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lh on 2016/8/11.
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("form", new ArticleForm());
        return "/article/form";
    }
}
