package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;

/**
 * ��service�����ṩ��̨����Ա�����ķ���
 */

public interface AdminService {
	
	/**
	 * ����Ա��¼
	 */
	Result adminLogin(String account, String password);

	/**
	 * ����Ա�޸�����
	 */
	Result adminChangePassword(Admin admin, String newPassword);
	
}
