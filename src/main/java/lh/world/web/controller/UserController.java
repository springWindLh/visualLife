package lh.world.web.controller;

import lh.world.web.controller.support.AjaxResponse;
import lh.world.web.controller.support.BaseController;
import lh.world.domain.User;
import lh.world.form.UserForm;
import lh.world.service.UserService;
import lh.world.util.EncrptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by lh on 2016/8/11.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse update(@RequestBody UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Optional<User> userOptional = userService.findById(form.getId());
        if (!userOptional.isPresent()) {
            return getAjaxResourceNotFound();
        }
        User user = form.asUser();
        user.setRole(userOptional.get().getRole());
        try {
            getRequest().getSession().setAttribute("user", userService.save(user));
            return AjaxResponse.ok().msg("保存成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/update/password/{id}", method = RequestMethod.GET)
    @ResponseBody
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
        user.setPassword(EncrptUtil.encodePassword(user.getPassword()));
        try {
            userService.save(user);
            return AjaxResponse.ok().msg("密码修改成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

}
