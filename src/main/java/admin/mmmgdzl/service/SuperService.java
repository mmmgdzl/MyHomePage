package admin.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;

import java.util.List;

/**
 * 该service用于提供后台超级管理员操作的服务
 */

public interface SuperService {

    /**
     * 添加管理员
     */
    boolean addAdmin(Admin admin, Admin currentAdmin);

    /**
     * 更新管理员信息
     */
   Admin updateAdminSelective(Admin admin);

    /**
     * 删除管理员
     */
    boolean deleteAdminsByIds(Integer[] ids);

    /**
     * 根据id查询管理员
     */
    Admin selectAdminById(Integer id);

    /**
     * 根据管理员账号查询管理员
     */
    Admin selectAdminByAccount(String account);

    /**
     * 根据管理员邮箱查询管理员
     */
    Admin selectAdminByMail(String mail);

    /**
     * 根据条件查询一组管理员
     */
    LayUIResult<LayUIAdmin> selectAdminsForLayUI(Admin admin, Integer currentPage, Integer pageSize);

    /**
     * 根据条件查询总条数
     */
    Integer count(AdminExample adminExample);
}
