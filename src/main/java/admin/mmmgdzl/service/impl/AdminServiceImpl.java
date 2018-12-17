package admin.mmmgdzl.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import admin.mmmgdzl.service.AdminService;

import com.mmmgdzl.domain.Result;
import com.mmmgdzl.mapper.AdminMapper;
import com.mmmgdzl.pojo.Admin;
import com.mmmgdzl.pojo.AdminExample;
import com.mmmgdzl.pojo.AdminExample.Criteria;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Result adminLogin(String account, String password) {
		//创建查询条件
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		criteria.andAccountEqualTo(account);
		//执行查询
		List<Admin> adminList = adminMapper.selectByExample(adminExample);
		//判断查询结果是否为空，若不为空则判断密码是否正确
		if(adminList == null || adminList.size() == 0 
				|| StringUtils.isBlank(account) || StringUtils.isBlank(password)
				|| !adminList.get(0).getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes())))
			return Result.build(500, "账号或密码错误!");
		//结果正确返回数据
		return Result.OK(adminList.get(0));
	}

	@Test
	public void test() {
		System.out.println(DigestUtils.md5DigestAsHex("asd".getBytes()));
	}

}
