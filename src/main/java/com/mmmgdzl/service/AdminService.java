package com.mmmgdzl.service;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;

/**
 * ��service�����ṩ��̨����Ա�����ķ���
 */

public interface AdminService {
	/**
	 * �û���¼
	 */
	Admin adminLogin(String account, String password);

	/**
	 * �û�ע��
	 */
	Result adminRegister(Admin admin);

	/**
	 * �û��޸�����
	 */
	Result adminChangePassword(Admin admin, String newPassword);

	/**
	 * �û��޸ĸ�����Ϣ
	 */
	Result adminUpdateInfo(Admin admin);

	/**
	 * �û�����
	 */
	Result adminActive(String activeCode);


	
}
