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
 * 该Service提供管理员管理服务
 */
@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminLevelMapper adminLevelMapper;

    @Override
    public boolean addAdmin(Admin admin, Admin currentAdmin) throws RuntimeException {
        //查询管理员账号是否已经存在
        Admin a = selectAdminByAccount(admin.getAaccount());
        if(a != null) {
            if(a.getAactive() == 0) {
                //若已经存在但未激活则删除原记录
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //若已经存在且已激活则抛出异常
                throw new XKException("该管理员账号已存在!");
            }
        }
        //验证邮箱是否已经存在
        a = selectAdminByMail(admin.getAmail());
        if(a != null) {
            if(a.getAactive() == 0) {
                //若已经存在但未激活则删除原记录
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //若已经存在且已激活则抛出异常
                throw new XKException("该邮箱已被注册!");
            }
        }
        //填充数据
        admin.setAid(0);
        admin.setAenable(1);
        admin.setAactive(1);
        //设置激活码为当前管理员编号
        admin.setAactivecode(currentAdmin.getAid() + "");
        admin.setAcreatedate(new Date());
        admin.setAheadimg("default.jpg");
        //执行密码MD5加密
        admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));
        //清除空值
        ClearBlankUtil.clearStringBlank(admin);
        //自动生成昵称
        if(admin.getAname() == null) {
            admin.setAname(admin.getAaccount());
        }
        //执行插入操作
        adminMapper.insert(admin);
        return true;
    }

    @Override
    public Admin updateAdminSelective(Admin admin) throws RuntimeException {
        //清除空值
        ClearBlankUtil.clearStringBlank(admin);

        //验证账号是否已经存在
        Admin checkAdmin = this.selectAdminByAccount(admin.getAaccount());
        if(checkAdmin != null && !checkAdmin.getAid().equals(admin.getAid())) {
            if(checkAdmin.getAactive() == 0) {
                //若已经存在且不是当前编辑账号且未激活则删除此重复项
                adminMapper.deleteByPrimaryKey(checkAdmin.getAid());
            } else {
                //若已经存在且不是当前编辑账号且已激活则抛出异常
                throw new XKException("该账号已经存在");
            }
        }
        //验证邮箱是否已经存在
        checkAdmin = this.selectAdminByMail(admin.getAmail());
        if(checkAdmin != null && !checkAdmin.getAid().equals(admin.getAid())) {
            if(checkAdmin.getAactive() == 0) {
                //若已经存在且不是当前编辑账号且未激活则删除此重复项
                adminMapper.deleteByPrimaryKey(checkAdmin.getAid());
            } else {
                //若已经存在且不是当前编辑账号且已激活则抛出异常
                throw new XKException("该邮箱已被注册");
            }
        }
        //若密码不为空, 则将密码进行MD5加密
        if(StringUtils.isNotBlank(admin.getApassword()))
            admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));
        //根据已有元素进行更新而不是完全更新
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
        //创建模板对象
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //设置查询条件
        criteria.andAaccountEqualTo(account);
        //执行查询
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size() == 0) {
            //如果查询结果为空则返回null
            return null;
        } else {
            //如果查询结果不为空则返回第一个值
            return admins.get(0);
        }
    }

    @Override
    public Admin selectAdminByMail(String mail) {
        if(mail == null) {
            return null;
        }
        //创建模板对象
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //设置查询条件
        criteria.andAmailEqualTo(mail);
        //执行查询
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if(admins.size() == 0) {
            //如果查询结果为空则返回null
            return null;
        } else {
            //如果查询结果不为空则返回第一个值
            return admins.get(0);
        }
    }

    @Override
    public LayUIResult<LayUIAdmin> selectAdminsForLayUI(Admin admin, Integer currentPage, Integer pageSize) {
        //创建模板对象
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();

        //添加查询条件
        if(admin != null) {
            //清除空值
            ClearBlankUtil.clearStringBlank(admin);
            //添加查询条件
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
        //获取总条数
        int totalNum = this.count(ae);
        //设置分页
        PageHelper.startPage(currentPage, pageSize);
        //执行查询
        List<Admin> adminList = adminMapper.selectByExample(ae);
        //执行数据渲染
        List<LayUIAdmin> adminList2 = new ArrayList<>();
        for(Admin admin1 : adminList) {
            LayUIAdmin layUIAdmin = new LayUIAdmin(admin1);
            layUIAdmin.setAlevel(adminLevelMapper.selectByPrimaryKey(admin1.getAlevel()).getLname());
            adminList2.add(layUIAdmin);
        }
        //消除密码
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
