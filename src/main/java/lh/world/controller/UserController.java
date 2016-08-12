package lh.world.controller;

import lh.world.controller.support.BaseController;
import lh.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lh on 2016/8/11.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;


}
