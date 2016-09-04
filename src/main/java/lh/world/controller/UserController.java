package lh.world.controller;

import lh.world.controller.support.AjaxResponse;
import lh.world.controller.support.BaseController;
import lh.world.domain.Article;
import lh.world.domain.User;
import lh.world.form.UserForm;
import lh.world.query.support.Query;
import lh.world.service.ArticleService;
import lh.world.service.UserService;
import lh.world.util.EncrptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by lh on 2016/8/11.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Long id, Model model) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return getResourceNotFound();
        }
        model.addAttribute("form", new UserForm(userOptional.get()));
        return "/user/form";
    }

    @RequestMapping(value = "/update/password/{id}", method = RequestMethod.POST)
    public AjaxResponse updatePassword(@PathVariable Long id, @RequestParam String oldPassword, @RequestParam String newPassword) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return getAjaxResourceNotFound();
        }
        User user = userOptional.get();
        if (!EncrptUtil.matchesPassword(oldPassword, user.getPassword())) {
            return AjaxResponse.fail().msg("原密码错误");
        }
        user.setPassword(newPassword);
        try {
            userService.save(user);
            return AjaxResponse.ok().msg("密码修改成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

}
