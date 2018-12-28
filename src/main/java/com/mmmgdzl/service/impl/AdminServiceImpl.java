package com.mmmgdzl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.mmmgdzl.service.SuperService;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.utils.ClearBlankUtil;
import com.mmmgdzl.utils.SendMailQQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.mmmgdzl.service.AdminService;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.pojo.AdminExample.Criteria;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private SuperService superService;
	@Value("${ACTIVE_MAIL_WEB_SITE}")
	private String ACTIVE_MAIL_WEB_SITE;

	@Override
	public Admin adminLogin(String account, String password) {
		//根据账号查询管理员
		Admin admin = superService.selectAdminByAccount(account);
		//判断查询结果是否为空，若不为空则判断密码是否为空且是否正确
		if(admin == null || !admin.getApassword().equals(DigestUtils.md5DigestAsHex(password.getBytes())))
			throw new XKException("账号或密码错误");
		if(admin.getAactive() == 0)
			throw new XKException("该账号未激活");
        if(admin.getAenable() == 0)
			throw new XKException("该账号已被冻结");
		//结果正确返回管理员对象
		return admin;
	}

	@Override
	public Result adminRegister(Admin admin) {
		//查询管理员账号是否已经存在
		Admin a = superService.selectAdminByAccount(admin.getAaccount());
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
		a = superService.selectAdminByMail(admin.getAmail());
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
		admin.setAenable(0);
		admin.setAactive(0);
		admin.setAlevel(2);
		admin.setAgender(2);
		admin.setAcreatedate(new Date());
		admin.setAheadimg("default.jpg");
		admin.setAname(admin.getAaccount());
		//创建激活码并设置
		String activeCode = UUID.randomUUID().toString().replace("-", "");
		admin.setAactivecode(activeCode);
		//执行密码MD5加密
		admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));

		//执行插入
		adminMapper.insert(admin);

		//开启线程执行发送邮件
		new Thread(new Runnable() {
			@Override
			public void run() {
				//发送激活邮件
				String mailContent = "欢迎光临星空の幻域, 您已在星空の聚合中申请注册账号,请点击下方链接激活账号!<br>" +
						"<a href='http://" + ACTIVE_MAIL_WEB_SITE + "/xk/activeAccount/" + activeCode + "'>http://" + ACTIVE_MAIL_WEB_SITE + "/xk/activeAccount/" + activeCode + "</a>";
				try {
					SendMailQQ.sendMail("738272815@qq.com", admin.getAmail(), "星空の聚合-账号申请", mailContent);
				} catch (Exception e) {
					//删除注册记录
					adminMapper.deleteByPrimaryKey(superService.selectAdminByAccount(admin.getAaccount()).getAid());
					throw new XKException("激活邮件发送失败, 请重新申请!");
				}
			}
		}).start();
		return Result.OK("http://mail." + admin.getAmail().substring(admin.getAmail().lastIndexOf("@") + 1));
	}

	@Override
	public Result adminActive(String activeCode) {
		//创建查询模板
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		//添加查询条件
		criteria.andAactivecodeEqualTo(activeCode);
		//执行查询
		List<Admin> admins = adminMapper.selectByExample(adminExample);
		//如果查询结果为空
		if(admins.size() == 0)
			throw new XKException("无效的激活码");
		//如果查询所得用户已被激活
		if(admins.get(0).getAactive() == 1)
			throw new XKException("该激活码已被使用");
		//更新激活状态
		Admin admin = new Admin();
		admin.setAid(admins.get(0).getAid());
		admin.setAenable(1);
		admin.setAactive(1);
		adminMapper.updateByPrimaryKeySelective(admin);

		//返回成功结果(附带用户账号)
		return Result.OK(admins.get(0).getAaccount());
	}

	@Override
	public Result adminChangePassword(Admin admin, String newPassword) {
		//获取id对应的管理员对象
		Admin checkAdmin = adminMapper.selectByPrimaryKey(admin.getAid());
		//判断原密码是否正确
		if(!checkAdmin.getApassword().equals(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()))) {
			//若不正确则抛出异常
			throw new XKException("原密码输入错误");
		}
		//若正确则执行修改
		//创建修改对象
		Admin a = new Admin();
		a.setAid(admin.getAid());
		//MD5加密密码
		a.setApassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		//执行选择性修改
		adminMapper.updateByPrimaryKeySelective(a);
		//返回成功结果
		return Result.OK();
	}

	@Override
	public Result adminUpdateInfo(Admin admin) {
		//清除空值
		ClearBlankUtil.clearStringBlank(admin);

		//验证邮箱是否已经存在
		Admin checkAdmin = superService.selectAdminByMail(admin.getAmail());
		if(checkAdmin != null && !checkAdmin.getAid().equals(admin.getAid())) {
			if(checkAdmin.getAactive() == 0) {
				//若已经存在且不是当前编辑账号且未激活则删除此重复项
				adminMapper.deleteByPrimaryKey(checkAdmin.getAid());
			} else {
				//若已经存在且不是当前编辑账号且已激活则抛出异常
				throw new XKException("该邮箱已被注册");
			}
		}
		//根据已有元素进行更新
		adminMapper.updateByPrimaryKeySelective(admin);
		//返回成功结果
		return Result.OK();
	}
}
