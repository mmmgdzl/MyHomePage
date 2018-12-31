package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdminLoginInfo;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminLoginInfo;
import com.mmmgdzl.pojo.AdminLoginInfoExample;

import java.util.List;

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

	/**
	 * ��¼����Ա��½��Ϣ
	 */
	Result saveAdminLoginInfo(Integer aId, String alIP, String alAddress);

    /**
     * ���û���¼��¼����ת��Ϊ��ѯģ�����
     */
    AdminLoginInfoExample transformAdminLoginInfoToAdminLoginInfoExample(AdminLoginInfo adminLoginInfo, Admin currentAdmin);

    /**
     * ���ݲ�ѯ������ѯ�û���¼��¼
     */
    List<AdminLoginInfo> selectAdminLoginInfos(AdminLoginInfo adminLoginInfo, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * ���ݲ�ѯ������ѯ�û���¼��¼
     */
    List<AdminLoginInfo> selectAdminLoginInfos(AdminLoginInfoExample adminLoginInfoExample, Integer currentPage, Integer pageSize);

    /**
     * ���ݲ�ѯ����ͳ���û���¼��¼����
     */
    Integer countAdminLoginInfo(AdminLoginInfo adminLoginInfo, Admin currentAdmin);

    /**
     * ���ݲ�ѯ����ͳ���û���¼��¼����
     */
    Integer countAdminLoginInfo(AdminLoginInfoExample adminLoginInfoExample);

    /**
     * ��AdminLoginInfo������ȾΪLauUIAdminLoginInfo����
     */
    LayUIAdminLoginInfo renderAdminLoginInfoForLayUI(AdminLoginInfo adminLoginInfo);

    /**
     * ��һ��AdminLoginInfo������ȾΪLauUIAdminLoginInfo����
     */
    List<LayUIAdminLoginInfo> renderAdminLoginInfosForLayUI(List<AdminLoginInfo> adminLoginInfos);

}
