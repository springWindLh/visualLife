package lh.world.controller;

import com.google.common.base.Strings;
import lh.world.controller.support.AjaxResponse;
import lh.world.controller.support.BaseController;
import lh.world.domain.User;
import lh.world.form.UserForm;
import lh.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by lh on 2016/8/11.
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse login(@RequestParam String nameOrMobile, @RequestParam String password) {
        final String errorMsg = "用户名或密码错误";
        if (Strings.isNullOrEmpty(nameOrMobile) || Strings.isNullOrEmpty(password)) {
            return AjaxResponse.fail().msg(errorMsg);
        }
        Optional<User> userOptional = userService.verifyUser(nameOrMobile, nameOrMobile, password);
        if (userOptional.isPresent()) {
            getRequest().getSession().setAttribute("user", userOptional.get());
            return AjaxResponse.ok().msg("登录成功").jumpUrl("/home");
        } else {
            return AjaxResponse.fail().msg(errorMsg);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse register(@RequestBody UserForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        User user = form.asUser();
        try {
            User currentUser = userService.save(user);
            getRequest().getSession().setAttribute("user", currentUser);
            return AjaxResponse.ok().msg("注册成功").jumpUrl("/home");
        } catch (RuntimeException e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        if (getCurrentUser() != null) {
            getRequest().getSession().removeAttribute("user");
        }
        return "redirect:/home";
    }

}
