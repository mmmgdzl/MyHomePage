package admin.mmmgdzl.controller;

import javax.servlet.http.HttpSession;

import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.mmmgdzl.service.AdminService;

import com.mmmgdzl.domain.Result;

/**
 * 该Controller用于提供后台管理员操作的前端访问接口
 */

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * 管理员登录
	 */
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

	/**
	 * 管理员登出
	 */
	@RequestMapping("/xk/adminLogout")
	@ResponseBody
	public Result adminLogout(HttpSession httpSession) {
		httpSession.setAttribute("admin", null);
		return Result.OK();
	}

	/**
	 * 管理员修改密码
	 */
	@RequestMapping("/xk/doChangePassword")
	@ResponseBody
	public Result changePassword(Admin admin, String newPassword) {
		Result result = null;
		try{
			result = adminService.adminChangePassword(admin, newPassword);
		} catch (XKException e) {
			return Result.build(500, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return  Result.build(500, "未知错误");
		}
		return result;
	}

}
