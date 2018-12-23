package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;

/**
 * 该service用于提供后台管理员操作的服务
 */

public interface AdminService {
	/**
	 * 用户登录
	 */
	Result adminLogin(String account, String password);

	/**
	 * 用户修改密码
	 */
	Result adminChangePassword(Admin admin, String newPassword);

	/**
	 * 用户修改个人信息
	 */
	Result adminUpdateInfo(Admin admin);

	/**
	 * 管理员注册
	 */
	Result adminRegister(Admin admin);

	/**
	 * 管理员激活
	 */
	Result adminActive(String activeCode);


	
}
