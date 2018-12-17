package admin.mmmgdzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SuperPageController {

    @RequestMapping("/xk/super/{path}")
    public String toSuperPage(@PathVariable String path) {
        return "xk/super/" + path;
    }

}
