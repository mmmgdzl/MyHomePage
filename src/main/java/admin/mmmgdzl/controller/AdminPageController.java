package admin.mmmgdzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 该Controller用于提供后台页面跳转接口
 */

@Controller
public class AdminPageController {

	@RequestMapping("/xk")
	public String toAdminLogin() {
		return "xk/login";
	}

	@RequestMapping("/xk/index")
	public String toStartPage() {
		return "xk/outside";
	}

	@RequestMapping("/xk/{page}")
	public String toAdminPage(@PathVariable String page) {
		return "xk/" + page;
	}

}
