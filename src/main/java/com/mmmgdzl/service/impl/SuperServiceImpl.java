package com.mmmgdzl.service.impl;

import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.service.FileService;
import com.github.pagehelper.PageHelper;
import com.mmmgdzl.domain.LayUIAdmin;
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
import com.mmmgdzl.domain.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private FileService fileService;
    @Autowired
    private AdminLevelMapper adminLevelMapper;

    @Override
    public Result addAdmin(Admin admin, Admin currentAdmin) {
        //��ѯ�û��˺��Ƿ��Ѿ�����
        Admin a = selectAdminByAccount(admin.getAaccount());
        if(a != null) {
            if(a.getAactive() == 0) {
                //���Ѿ����ڵ�δ������ɾ��ԭ��¼
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //���Ѿ��������Ѽ������׳��쳣
                throw new XKException("���˺ű�ע��");
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
                throw new XKException("�������ѱ�ע��");
            }
        }
        //�������
        admin.setAid(0);
        admin.setAenable(1);
        admin.setAactive(1);
        //���ü�����Ϊ��ǰ�û����
        admin.setAactivecode(currentAdmin.getAid() + "");
        admin.setAcreatedate(new Date());
        admin.setAheadimg("default.jpg");
        //ִ������MD5����
        admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));
        //�����ֵ
        ClearBlankUtil.clearStringBlank(admin);
        //����ǳ�Ϊ���������ǳ����˺���ͬ
        if(admin.getAname() == null) {
            admin.setAname(admin.getAaccount());
        }
        //ִ�в������
        adminMapper.insert(admin);
        //���سɹ���Ϣ
        return Result.OK();
    }

    @Override
    public AdminExample transformAdminToAdminExample(Admin admin) {
        //����հ���
        ClearBlankUtil.clearStringBlank(admin);
        //������ѯģ�����
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();
        //���Ӳ�ѯ����
        if(admin != null) {
            //�����ֵ
            ClearBlankUtil.clearStringBlank(admin);
            //���Ӳ�ѯ����
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
        //���ز�ѯģ�����
        return ae;
    }

    @Override
    public List<Admin> selectAdmins(AdminExample adminExample, Integer currentPage, Integer pageSize) {
        if(currentPage != null && pageSize != null) {
            //���÷�ҳ
            PageHelper.startPage(currentPage, pageSize);
        }
        //ִ�в�ѯ
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        //��������
        for(Admin a : adminList) {
            a.setApassword(null);
        }
        //���ع���Ա�б�
        return adminList;
    }

    @Override
    public List<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize) {
        //������Ա����ת��Ϊ��ѯģ�����
        AdminExample adminExample = this.transformAdminToAdminExample(admin);
        //ִ�в�ѯ������
        return this.selectAdmins(adminExample, currentPage, pageSize);
    }

    @Override
    public Integer count(AdminExample adminExample) {
        return adminMapper.countByExample(adminExample);
    }

    @Override
    public Integer count(Admin admin) {
        //������Ա����ת��Ϊ��ѯģ�����
        AdminExample adminExample = this.transformAdminToAdminExample(admin);
        //ִ��ͳ�Ʋ�����
        return count(adminExample);
    }

    @Override
    public LayUIAdmin renderAdminForLayUI(Admin admin) {
        LayUIAdmin layUIAdmin = new LayUIAdmin(admin);
        //��Ⱦ�û��ȼ�����
        layUIAdmin.setAlevel(adminLevelMapper.selectByPrimaryKey(admin.getAlevel()).getLname());
        //������Ⱦ���
        return layUIAdmin;
    }

    @Override
    public List<LayUIAdmin> renderAdminsForLayUI(List<Admin> admins) {
        //ִ��������Ⱦ
        List<LayUIAdmin> adminList = new ArrayList<>();
        for(Admin admin : admins) {
            adminList.add(renderAdminForLayUI(admin));
        }
        //������Ⱦ����û��б�
        return adminList;
    }

    @Override
    public Admin updateAdminSelective(Admin admin) {
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
                throw new XKException("���˺��ѱ�ע��");
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
        //���ظ��º���û�
        return adminMapper.selectByPrimaryKey(admin.getAid());
    }

    @Override
    public Result deleteAdminsByIds(List<Integer> idList) {
        if(idList != null) {
            for (Integer id : idList) {
                //ɾ��ͷ���ļ�
                fileService.deletePreHeadImg(id);
                //ɾ������Ա
                adminMapper.deleteByPrimaryKey(id);
            }
        }
        return Result.OK();
    }

    @Override
    public Admin selectAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin selectAdminByAccount(String account) {
        if(StringUtils.isBlank(account)) {
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
        if(StringUtils.isBlank(mail)) {
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
    public Admin renderAdminIntroduce(Admin admin) {
        if(StringUtils.isBlank(admin.getAintroduce())) {
            admin.setAintroduce("�������, �����ܶ�ûд~~");
        }
        return admin;
    }

    @Override
    public List<Admin> renderAdminsIntroduce(List<Admin> admins) {
        for(Admin admin : admins) {
            renderAdminIntroduce(admin);
        }
        return admins;
    }
}