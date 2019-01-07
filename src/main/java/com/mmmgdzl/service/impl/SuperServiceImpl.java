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

import java.text.SimpleDateFormat;
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
        //查询用户账号是否已经存在
        Admin a = this.selectAdminByAccount(admin.getAaccount());
        if(a != null) {
            if(a.getAactive() == 0) {
                //若已经存在但未激活则删除原记录
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //若已经存在且已激活则抛出异常
                throw new XKException("该账号被注册");
            }
        }
        //验证邮箱是否已经存在
        a = this.selectAdminByMail(admin.getAmail());
        if(a != null) {
            if(a.getAactive() == 0) {
                //若已经存在但未激活则删除原记录
                adminMapper.deleteByPrimaryKey(a.getAid());
            } else {
                //若已经存在且已激活则抛出异常
                throw new XKException("该邮箱已被注册");
            }
        }
        //填充数据
        admin.setAid(0);
        admin.setAenable(1);
        admin.setAactive(1);
        //设置激活码为当前用户编号
        admin.setAactivecode(currentAdmin.getAid() + "");
        admin.setAcreatedate(new Date());
        admin.setAheadimg("default.jpg");
        //执行密码MD5加密
        admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));
        //清除空值
        ClearBlankUtil.clearStringBlank(admin);
        //如果昵称为空则设置昵称与账号相同
        if(admin.getAname() == null) {
            admin.setAname(admin.getAaccount());
        }
        //执行插入操作
        adminMapper.insert(admin);
        //返回成功信息
        return Result.OK();
    }

    @Override
    public AdminExample transformAdminToAdminExample(Admin admin) {
        //创建查询模板对象
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
            if(admin.getAactive() != null)
                criteria.andAactiveEqualTo(admin.getAactive());
            //如果查询不指定显示删除状态数据则不显示
            if(admin.getAenable() != null)
                criteria.andAenableEqualTo(admin.getAenable());
            else
                criteria.andAenableNotEqualTo(2);
        }
        //返回查询模板对象
        return ae;
    }

    @Override
    public List<Admin> selectAdmins(AdminExample adminExample, Integer currentPage, Integer pageSize) {
        if(currentPage != null && pageSize != null) {
            //设置分页
            PageHelper.startPage(currentPage, pageSize);
        }
        //执行查询
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        //消除密码
        for(Admin a : adminList) {
            a.setApassword(null);
        }
        //返回管理员列表
        return adminList;
    }

    @Override
    public List<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize) {
        //将管理员对象转换为查询模板对象
        AdminExample adminExample = this.transformAdminToAdminExample(admin);
        //执行查询并返回
        return this.selectAdmins(adminExample, currentPage, pageSize);
    }

    @Override
    public Integer count(AdminExample adminExample) {
        return adminMapper.countByExample(adminExample);
    }

    @Override
    public Integer count(Admin admin) {
        //将管理员对象转换为查询模板对象
        AdminExample adminExample = this.transformAdminToAdminExample(admin);
        //执行统计并返回
        return count(adminExample);
    }

    @Override
    public LayUIAdmin renderAdminForLayUI(Admin admin) {
        LayUIAdmin layUIAdmin = new LayUIAdmin();
        //执行渲染
        layUIAdmin.setAid(admin.getAid());
        layUIAdmin.setAaccount(admin.getAaccount());
        if(admin.getAenable() == 0) {
            layUIAdmin.setAenable("不可用");
        } else if(admin.getAenable() == 1) {
            layUIAdmin.setAenable("可用");
        } else if(admin.getAenable() == 2){
            layUIAdmin.setAenable("删除");
        }
        if(admin.getAactive() == 0) {
            layUIAdmin.setAactive("未激活");
        } else {
            layUIAdmin.setAactive("已激活");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        layUIAdmin.setAcreatedate(sdf.format(admin.getAcreatedate()));
        layUIAdmin.setAname(admin.getAname());
        if(admin.getAgender() == 0) {
            layUIAdmin.setAgender("男");
        } else if(admin.getAgender() == 1) {
            layUIAdmin.setAgender("女");
        } else if(admin.getAgender() == 2) {
            layUIAdmin.setAgender("保密");
        }
        layUIAdmin.setAmail(admin.getAmail());
        layUIAdmin.setAphone(admin.getAphone());
        layUIAdmin.setAintroduce(admin.getAintroduce());
        //渲染用户等级名称
        layUIAdmin.setAlevel(adminLevelMapper.selectByPrimaryKey(admin.getAlevel()).getLname());
        //返回渲染结果
        return layUIAdmin;
    }

    @Override
    public List<LayUIAdmin> renderAdminsForLayUI(List<Admin> admins) {
        //执行数据渲染
        List<LayUIAdmin> adminList = new ArrayList<>();
        for(Admin admin : admins) {
            adminList.add(renderAdminForLayUI(admin));
        }
        //返回渲染后的用户列表
        return adminList;
    }

    @Override
    public Admin updateAdminSelective(Admin admin) {
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
                throw new XKException("该账号已被注册");
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
        //返回更新后的用户
        return adminMapper.selectByPrimaryKey(admin.getAid());
    }

    @Override
    public Result deleteAdminsByIds(List<Integer> idList) {
        Admin deleteAdmin = new Admin();
        deleteAdmin.setAenable(2);
        deleteAdmin.setAheadimg("default.jpg");
        if(idList != null) {
            for (Integer id : idList) {
                //删除头像文件
                fileService.deletePreHeadImg(id);
                //删除用户(将用户状态设置为2)
                deleteAdmin.setAid(id);
                adminMapper.updateByPrimaryKeySelective(deleteAdmin);
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
        //创建模板对象
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //设置查询条件
        criteria.andAaccountEqualTo(account);
        //查询未删除数据
        criteria.andAenableNotEqualTo(2);
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
        if(StringUtils.isBlank(mail)) {
            return null;
        }
        //创建模板对象
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        //设置查询条件
        criteria.andAmailEqualTo(mail);
        //查询未删除数据
        criteria.andAenableNotEqualTo(2);
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
    public Admin renderAdminIntroduce(Admin admin) {
        if(StringUtils.isBlank(admin.getAintroduce())) {
            admin.setAintroduce("这货很懒, 连介绍都没写~~");
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
