package admin.mmmgdzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
