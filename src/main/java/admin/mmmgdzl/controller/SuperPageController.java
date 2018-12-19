package admin.mmmgdzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该Controller用于提供超级管理员页面跳转接口
 */

@Controller
public class SuperPageController {

    @RequestMapping("/xk/super/{path}")
    public String toSuperPage(@PathVariable String path) {
        return "xk/super/" + path;
    }

}
