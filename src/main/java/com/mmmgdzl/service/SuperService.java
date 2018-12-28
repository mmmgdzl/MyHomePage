package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.domain.Result;

import java.util.List;

/**
 * 该service用于提供后用户管理的服务
 */
public interface SuperService {

    /**
     * 添加用户
     */
    Result addAdmin(Admin admin, Admin currentAdmin);

    /**
     * 将用户对象转换为用户查询模板对象
     */
    AdminExample transformAdminToAdminExample(Admin admin);

    /**
     * 根据条件查询一组用户
     */
    List<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize);

    /**
     * 根据条件查询一组用户
     */
    List<Admin> selectAdmins(AdminExample adminExample, Integer currentPage, Integer pageSize);

    /**
     * 根据条件查询总条数
     */
    Integer count(Admin admin);

    /**
     * 根据条件查询总条数
     */
    Integer count(AdminExample adminExample);

    /**
     * 为LayUI渲染用户
     */
    LayUIAdmin renderAdminForLayUI(Admin admin);

    /**
     * 为LayUI渲染一组用户
     */
    List<LayUIAdmin> renderAdminsForLayUI(List<Admin> admins);

    /**
     * 更新用户信息
     */
   Admin updateAdminSelective(Admin admin);

    /**
     * 删除用户
     */
    Result deleteAdminsByIds(List<Integer> idList);

    /**
     * 根据id查询用户
     */
    Admin selectAdminById(Integer id);

    /**
     * 根据管理员账号查询用户
     */
    Admin selectAdminByAccount(String account);

    /**
     * 根据管理员邮箱查询用户
     */
    Admin selectAdminByMail(String mail);

    /**
     * 渲染用户个人介绍
     */
    Admin renderAdminIntroduce(Admin admin);

    /**
     * 渲染用户个人介绍(列表)
     */
    List<Admin> renderAdminsIntroduce(List<Admin> admins);
}
