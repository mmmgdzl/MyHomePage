package admin.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;

import java.util.List;

public interface SuperService {

    /**
     * ��ӹ���Ա
     */
    boolean addAdmin(Admin admin);

    /**
     * ���¹���Ա��Ϣ
     */
   boolean updateAdminSelective(Admin admin);

    /**
     * ɾ������Ա
     */
    boolean deleteAdminsByIds(Integer[] ids);

    /**
     * ����id��ѯ����Ա
     */
    Admin selectAdminById(Integer id);

    /**
     * ���ݹ���Ա�˺Ų�ѯ����Ա
     */
    Admin selectAdminByAccount(String account);

    /**
     * ����������ѯһ�����Ա
     */
    LayUIResult<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize);

    /**
     * ����������ѯ������
     */
    Integer count(AdminExample adminExample);
}
