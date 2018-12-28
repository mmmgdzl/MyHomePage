package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.domain.Result;

import java.util.List;

/**
 * ��service�����ṩ���û�����ķ���
 */
public interface SuperService {

    /**
     * ����û�
     */
    Result addAdmin(Admin admin, Admin currentAdmin);

    /**
     * ���û�����ת��Ϊ�û���ѯģ�����
     */
    AdminExample transformAdminToAdminExample(Admin admin);

    /**
     * ����������ѯһ���û�
     */
    List<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize);

    /**
     * ����������ѯһ���û�
     */
    List<Admin> selectAdmins(AdminExample adminExample, Integer currentPage, Integer pageSize);

    /**
     * ����������ѯ������
     */
    Integer count(Admin admin);

    /**
     * ����������ѯ������
     */
    Integer count(AdminExample adminExample);

    /**
     * ΪLayUI��Ⱦ�û�
     */
    LayUIAdmin renderAdminForLayUI(Admin admin);

    /**
     * ΪLayUI��Ⱦһ���û�
     */
    List<LayUIAdmin> renderAdminsForLayUI(List<Admin> admins);

    /**
     * �����û���Ϣ
     */
   Admin updateAdminSelective(Admin admin);

    /**
     * ɾ���û�
     */
    Result deleteAdminsByIds(List<Integer> idList);

    /**
     * ����id��ѯ�û�
     */
    Admin selectAdminById(Integer id);

    /**
     * ���ݹ���Ա�˺Ų�ѯ�û�
     */
    Admin selectAdminByAccount(String account);

    /**
     * ���ݹ���Ա�����ѯ�û�
     */
    Admin selectAdminByMail(String mail);

    /**
     * ��Ⱦ�û����˽���
     */
    Admin renderAdminIntroduce(Admin admin);

    /**
     * ��Ⱦ�û����˽���(�б�)
     */
    List<Admin> renderAdminsIntroduce(List<Admin> admins);
}
