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
 * 该Service提供管理员管理服务
 */
@Service
public class SuperServiceImpl implements SuperService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean addAdmin(Admin admin) throws RuntimeException {
        //查询管理员账号是否已经存在
        Admin a = selectAdminByAccount(admin.getAccount());
        if(a != null) {
            //若已经存在则抛出异常
            throw new RuntimeException("该管理员账号已存在!");
        }
        //执行密码MD5加密
        admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        //执行插入操作
        adminMapper.insert(admin);
        return true;
    }

    @Override
    public boolean updateAdminSelective(Admin admin) throws RuntimeException {
        //消除虚假属性
        if(StringUtils.isBlank(admin.getAccount()))
            admin.setAccount(null);
        else {
            //验证账号是否已经存在
            Admin checkAdmin = this.selectAdminByAccount(admin.getAccount());
            if(checkAdmin != null && !checkAdmin.getId().equals(admin.getId()))
                //若已经存在且不是当前编辑账号则抛出异常
                throw new RuntimeException("该账号已经存在");
        }
        if(StringUtils.isBlank(admin.getPassword()))
            admin.setPassword(null);
        else
            admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        //根据已有元素进行更新而不是完全更新
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
        //创建模板对象
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();

        //设置查询条件
        criteria.andAccountEqualTo(account);
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
    public LayUIResult<Admin> selectAdmins(Admin admin, Integer currentPage, Integer pageSize) {
        //创建模板对象
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();

        //添加查询条件
        if(admin != null) {
            if (admin.getAccount() != null)
                criteria.andAccountLike("%" + admin.getAccount() + "%");
            if (admin.getLevel() != null)
                criteria.andLevelEqualTo(admin.getLevel());
        }
        //获取总条数
        int totalNum = count(ae);
        //设置分页
        PageHelper.startPage(currentPage, pageSize);
        //执行查询
        List<Admin> adminList = adminMapper.selectByExample(ae);
        //消除密码
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
