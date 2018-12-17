package admin.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;

import java.util.List;

public interface SuperService {

    /**
     * 添加管理员
     */
    boolean addAdmin(Admin admin);

    /**
     * 更新管理员信息
     */
   boolean updateAdminSelective(Admin admin);

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
     * 根据条件查询一组管理员
     */
    LayUIResult<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize);

    /**
     * 根据条件查询总条数
     */
    Integer count(AdminExample adminExample);
}
