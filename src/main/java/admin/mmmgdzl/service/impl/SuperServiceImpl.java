package admin.mmmgdzl.service.impl;

import admin.mmmgdzl.service.SuperService;
import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIAdmin;
import com.mmmgdzl.domain.LayUIResult;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.mapper.AdminLevelMapper;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.utils.ClearBlankUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ��Service�ṩ����Ա�������
 */
@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminLevelMapper adminLevelMapper;

    @Override
    public boolean addAdmin(Admin admin, Admin currentAdmin) throws RuntimeException {
        //��ѯ����Ա�˺��Ƿ��Ѿ�����
        Admin a = selectAdminByAccount(admin.getAaccount());
        if(a != null) {
            if(a.getAactive() == 0) {
                //���Ѿ����ڵ�δ������ɾ��ԭ��¼
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //���Ѿ��������Ѽ������׳��쳣
                throw new XKException("�ù���Ա�˺��Ѵ���!");
            }
        }
        //��֤�����Ƿ��Ѿ�����
        a = selectAdminByMail(admin.getAmail());
        if(a != null) {
            if(a.getAactive() == 0) {
                //���Ѿ����ڵ�δ������ɾ��ԭ��¼
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //���Ѿ��������Ѽ������׳��쳣
                throw new XKException("�������ѱ�ע��!");
            }
        }
        //�������
        admin.setAid(0);
        admin.setAenable(1);
        admin.setAactive(1);
        //���ü�����Ϊ��ǰ����Ա���
        admin.setAactivecode(currentAdmin.getAid() + "");
        admin.setAcreatedate(new Date());
        admin.setAheadimg("default.jpg");
        //ִ������MD5����
        admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));
        //�����ֵ
        ClearBlankUtil.clearStringBlank(admin);
        //�Զ������ǳ�
        if(admin.getAname() == null) {
            admin.setAname(admin.getAaccount());
        }
        //ִ�в������
        adminMapper.insert(admin);
        return true;
    }

    @Override
    public Admin updateAdminSelective(Admin admin) throws RuntimeException {
        //�����ֵ
        ClearBlankUtil.clearStringBlank(admin);

        //��֤�˺��Ƿ��Ѿ�����
        Admin checkAdmin = this.selectAdminByAccount(admin.getAaccount());
        if(checkAdmin != null && !checkAdmin.getAid().equals(admin.getAid())) {
            if(checkAdmin.getAactive() == 0) {
                //���Ѿ������Ҳ��ǵ�ǰ�༭�˺���δ������ɾ�����ظ���
                adminMapper.deleteByPrimaryKey(checkAdmin.getAid());
            } else {
                //���Ѿ������Ҳ��ǵ�ǰ�༭�˺����Ѽ������׳��쳣
                throw new XKException("���˺��Ѿ�����");
            }
        }
        //��֤�����Ƿ��Ѿ�����
        checkAdmin = this.selectAdminByMail(admin.getAmail());
        if(checkAdmin != null && !checkAdmin.getAid().equals(admin.getAid())) {
            if(checkAdmin.getAactive() == 0) {
                //���Ѿ������Ҳ��ǵ�ǰ�༭�˺���δ������ɾ�����ظ���
                adminMapper.deleteByPrimaryKey(checkAdmin.getAid());
            } else {
                //���Ѿ������Ҳ��ǵ�ǰ�༭�˺����Ѽ������׳��쳣
                throw new XKException("�������ѱ�ע��");
            }
        }
        //�����벻Ϊ��, ���������MD5����
        if(StringUtils.isNotBlank(admin.getApassword()))
            admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));
        //��������Ԫ�ؽ��и��¶�������ȫ����
        adminMapper.updateByPrimaryKeySelective(admin);
        return adminMapper.selectByPrimaryKey(admin.getAid());
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
        if(account == null) {
            return null;
        }
        //����ģ�����
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //���ò�ѯ����
        criteria.andAaccountEqualTo(account);
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
    public Admin selectAdminByMail(String mail) {
        if(mail == null) {
            return null;
        }
        //����ģ�����
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //���ò�ѯ����
        criteria.andAmailEqualTo(mail);
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
    public LayUIResult<LayUIAdmin> selectAdminsForLayUI(Admin admin, Integer currentPage, Integer pageSize) {
        //����ģ�����
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();

        //��Ӳ�ѯ����
        if(admin != null) {
            //�����ֵ
            ClearBlankUtil.clearStringBlank(admin);
            //��Ӳ�ѯ����
            if (admin.getAaccount() != null)
                criteria.andAaccountLike("%" + admin.getAaccount() + "%");
            if (admin.getAlevel() != null)
                criteria.andAlevelEqualTo(admin.getAlevel());
            if(admin.getAname() != null)
                criteria.andAnameLike("%"+ admin.getAname() + "%");
            if(admin.getAgender() != null)
                criteria.andAgenderEqualTo(admin.getAgender());
            if(admin.getAmail() != null)
                criteria.andAmailLike("%" + admin.getAmail() + "%");
            if(admin.getAphone() != null)
                criteria.andAphoneLike("%" + admin.getAphone() + "%");
        }
        //��ȡ������
        int totalNum = this.count(ae);
        //���÷�ҳ
        PageHelper.startPage(currentPage, pageSize);
        //ִ�в�ѯ
        List<Admin> adminList = adminMapper.selectByExample(ae);
        //ִ��������Ⱦ
        List<LayUIAdmin> adminList2 = new ArrayList<>();
        for(Admin admin1 : adminList) {
            LayUIAdmin layUIAdmin = new LayUIAdmin(admin1);
            layUIAdmin.setAlevel(adminLevelMapper.selectByPrimaryKey(admin1.getAlevel()).getLname());
            adminList2.add(layUIAdmin);
        }
        //��������
        for(Admin a : adminList) {
            a.setApassword(null);
        }
        return new LayUIResult<>(0, totalNum, adminList2);
    }

    @Override
    public Integer count(AdminExample adminExample) {
        return adminMapper.countByExample(adminExample);
    }
}
