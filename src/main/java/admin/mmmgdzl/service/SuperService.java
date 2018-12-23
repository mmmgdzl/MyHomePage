package admin.mmmgdzl.service;

import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;

import java.util.List;

/**
 * ��service�����ṩ��̨��������Ա�����ķ���
 */

public interface SuperService {

    /**
     * ��ӹ���Ա
     */
    boolean addAdmin(Admin admin, Admin currentAdmin);

    /**
     * ���¹���Ա��Ϣ
     */
   Admin updateAdminSelective(Admin admin);

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
     * ���ݹ���Ա�����ѯ����Ա
     */
    Admin selectAdminByMail(String mail);

    /**
     * ����������ѯһ�����Ա
     */
    LayUIResult<LayUIAdmin> selectAdminsForLayUI(Admin admin, Integer currentPage, Integer pageSize);

    /**
     * ����������ѯ������
     */
    Integer count(AdminExample adminExample);
}
