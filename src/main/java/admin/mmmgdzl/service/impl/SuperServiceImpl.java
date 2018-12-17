package admin.mmmgdzl.service.impl;

import admin.mmmgdzl.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * ��Service�ṩ����Ա�������
 */
@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean addAdmin(Admin admin) throws RuntimeException {
        //��ѯ����Ա�˺��Ƿ��Ѿ�����
        Admin a = selectAdminByAccount(admin.getAccount());
        if(a != null) {
            //���Ѿ��������׳��쳣
            throw new RuntimeException("�ù���Ա�˺��Ѵ���!");
        }
        //ִ������MD5����
        admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        //ִ�в������
        adminMapper.insert(admin);
        return true;
    }

    @Override
    public boolean updateAdminSelective(Admin admin) throws RuntimeException {
        //�����������
        if(StringUtils.isBlank(admin.getAccount()))
            admin.setAccount(null);
        else {
            //��֤�˺��Ƿ��Ѿ�����
            Admin checkAdmin = this.selectAdminByAccount(admin.getAccount());
            if(checkAdmin != null && !checkAdmin.getId().equals(admin.getId()))
                //���Ѿ������Ҳ��ǵ�ǰ�༭�˺����׳��쳣
                throw new RuntimeException("���˺��Ѿ�����");
        }
        if(StringUtils.isBlank(admin.getPassword()))
            admin.setPassword(null);
        else
            admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        //��������Ԫ�ؽ��и��¶�������ȫ����
        adminMapper.updateByPrimaryKeySelective(admin);
        return true;
    }

    @Override
    public boolean deleteAdminsByIds(Integer[] ids) {
        for(Integer id : ids) {
            adminMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public Admin selectAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin selectAdminByAccount(String account) {
        //����ģ�����
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //���ò�ѯ����
        criteria.andAccountEqualTo(account);
        //ִ�в�ѯ
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size() == 0) {
            //�����ѯ���Ϊ���򷵻�null
            return null;
        } else {
            //�����ѯ�����Ϊ���򷵻ص�һ��ֵ
            return admins.get(0);
        }
    }

    @Override
    public LayUIResult<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize) {
        //����ģ�����
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();

        //��Ӳ�ѯ����
        if(admin != null) {
            if (admin.getAccount() != null)
                criteria.andAccountLike("%" + admin.getAccount() + "%");
            if (admin.getLevel() != null)
                criteria.andLevelEqualTo(admin.getLevel());
        }
        //��ȡ������
        int totalNum = count(ae);
        //���÷�ҳ
        PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ
        List<Admin> adminList = adminMapper.selectByExample(ae);
        //��������
        for(Admin a : adminList) {
            a.setPassword(null);
        }
        return new LayUIResult<Admin>(0, totalNum, adminList);
    }

    @Override
    public Integer count(AdminExample adminExample) {
        return adminMapper.countByExample(adminExample);
    }
}
