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
		//������ѯ����
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		criteria.andAccountEqualTo(account);
		//ִ�в�ѯ
		List<Admin> adminList = adminMapper.selectByExample(adminExample);
		//�жϲ�ѯ����Ƿ�Ϊ�գ�����Ϊ�����ж������Ƿ���ȷ
		if(adminList == null || adminList.size() == 0 
				|| StringUtils.isBlank(account) || StringUtils.isBlank(password)
				|| !adminList.get(0).getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes())))
			return Result.build(500, "�˺Ż��������!");
		//�����ȷ��������
		return Result.OK(adminList.get(0));
	}

	@Test
	public void test() {
		System.out.println(DigestUtils.md5DigestAsHex("asd".getBytes()));
	}

}
