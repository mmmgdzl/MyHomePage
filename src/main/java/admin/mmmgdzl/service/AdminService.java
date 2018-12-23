package admin.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;

/**
 * ��service�����ṩ��̨����Ա�����ķ���
 */

public interface AdminService {
	/**
	 * �û���¼
	 */
	Result adminLogin(String account, String password);

	/**
	 * �û��޸�����
	 */
	Result adminChangePassword(Admin admin, String newPassword);

	/**
	 * �û��޸ĸ�����Ϣ
	 */
	Result adminUpdateInfo(Admin admin);

	/**
	 * ����Աע��
	 */
	Result adminRegister(Admin admin);

	/**
	 * ����Ա����
	 */
	Result adminActive(String activeCode);


	
}
