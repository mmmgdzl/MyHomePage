package admin.mmmgdzl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.mmmgdzl.service.AdminService;

import com.mmmgdzl.domain.Result;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/xk/adminLogin")
	@ResponseBody
	public Result adminLogin(String account, String password, HttpSession session) {
		//校对账号密码
		Result result = adminService.adminLogin(account, password);
		//如果登陆成功则将管理员信息放入session中
		if(result.getCode() == 200) {
			session.setAttribute("admin", result.getData());
			result.setData(null);
		}
		return result;
	}

}
