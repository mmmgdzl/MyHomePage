package com.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdminLoginInfo;
import com.mmmgdzl.domain.Result;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminLoginInfo;
import com.mmmgdzl.pojo.AdminLoginInfoExample;

import java.util.List;

/**
 * 该service用于提供后台管理员操作的服务
 */

public interface AdminService {
	/**
	 * 用户登录
	 */
	Admin adminLogin(String account, String password);

	/**
	 * 用户注册
	 */
	Result adminRegister(Admin admin);

	/**
	 * 用户修改密码
	 */
	Result adminChangePassword(Admin admin, String newPassword);

	/**
	 * 用户修改个人信息
	 */
	Result adminUpdateInfo(Admin admin);

	/**
	 * 用户激活
	 */
	Result adminActive(String activeCode);

	/**
	 * 记录管理员登陆信息
	 */
	Result saveAdminLoginInfo(Integer aId, String alIP, String alAddress);

    /**
     * 将用户登录记录对象转换为查询模板对象
     */
    AdminLoginInfoExample transformAdminLoginInfoToAdminLoginInfoExample(AdminLoginInfo adminLoginInfo, Admin currentAdmin);

    /**
     * 根据查询条件查询用户登录记录
     */
    List<AdminLoginInfo> selectAdminLoginInfos(AdminLoginInfo adminLoginInfo, Integer currentPage, Integer pageSize, Admin currentAdmin);

    /**
     * 根据查询条件查询用户登录记录
     */
    List<AdminLoginInfo> selectAdminLoginInfos(AdminLoginInfoExample adminLoginInfoExample, Integer currentPage, Integer pageSize);

    /**
     * 根据查询条件统计用户登录记录条数
     */
    Integer countAdminLoginInfo(AdminLoginInfo adminLoginInfo, Admin currentAdmin);

    /**
     * 根据查询条件统计用户登录记录条数
     */
    Integer countAdminLoginInfo(AdminLoginInfoExample adminLoginInfoExample);

    /**
     * 将AdminLoginInfo对象渲染为LauUIAdminLoginInfo对象
     */
    LayUIAdminLoginInfo renderAdminLoginInfoForLayUI(AdminLoginInfo adminLoginInfo);

    /**
     * 将一组AdminLoginInfo对象渲染为LauUIAdminLoginInfo对象
     */
    List<LayUIAdminLoginInfo> renderAdminLoginInfosForLayUI(List<AdminLoginInfo> adminLoginInfos);

}
