package lh.world.web.controller;

import lh.world.web.controller.support.AjaxResponse;
import lh.world.web.controller.support.BaseController;
import lh.world.domain.Article;
import lh.world.form.ArticleForm;
import lh.world.query.support.Query;
import lh.world.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by lh on 2016/8/11.
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("form", new ArticleForm());
        return "/article/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse add(@RequestBody @Valid ArticleForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Article article = form.asArticle();
        article.setUser(getCurrentUser());
        try {
            articleService.save(article);
            return AjaxResponse.ok().msg("发表成功").jumpUrl("/article/list");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable Long id, Model model) {
        Optional<Article> articleOptional = articleService.findById(id);
        if (!articleOptional.isPresent()) {
            return getResourceNotFound();
        }
        model.addAttribute("form", articleOptional.get());
        return "/article/detail";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Long id, Model model) {
        Optional<Article> articleOptional = articleService.findById(id);
        if (!articleOptional.isPresent()) {
            return getResourceNotFound();
        }
        model.addAttribute("form", new ArticleForm(articleOptional.get()));
        return "/article/form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse update(@RequestBody @Valid ArticleForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Optional<Article> articleOptional = articleService.findById(form.getId());
        if (!articleOptional.isPresent()) {
            return getAjaxResourceNotFound();
        }
        Article article = form.asArticle();
        article.setUser(articleOptional.get().getUser());
        try {
            articleService.save(article);
            return AjaxResponse.ok().msg("更新成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String userList(Query query, Model model) {
        Page<Article> page = articleService.listByUser(getCurrentUser(), query, false);
        model.addAttribute("page", page);
        return "/article/userList";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse remove(@PathVariable Long id) {
        try {
            articleService.remove(id);
            return AjaxResponse.ok().msg("删除成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/vote/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse vote(@PathVariable Long id) {
        Optional<Article> articleOptional = articleService.findById(id);
        if (!articleOptional.isPresent()) {
            return getAjaxResourceNotFound();
        }
        Article article = articleOptional.get();
        article.setVote(article.getVote() + 1);
        try {
            article = articleService.save(article);
            return AjaxResponse.ok().msg("点赞成功").data(article);
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }
}
