package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;

/**
 * 该service用于提供后台管理员操作的服务
 */

public interface AdminService {
	
	/**
	 * 管理员登录
	 */
	Result adminLogin(String account, String password);

	/**
	 * 管理员修改密码
	 */
	Result adminChangePassword(Admin admin, String newPassword);
	
}
