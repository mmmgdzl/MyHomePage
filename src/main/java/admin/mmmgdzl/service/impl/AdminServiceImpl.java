package admin.mmmgdzl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import admin.mmmgdzl.service.SuperService;
import com.mmmgdzl.exception.XKException;
import com.mmmgdzl.utils.ClearBlankUtil;
import com.mmmgdzl.utils.SendMailQQ;
import org.apache.commons.lang.StringUtils;
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
	@Autowired
	private SuperService superService;

	@Override
	public Result adminLogin(String account, String password) {
		//������ѯ����
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();
		criteria.andAaccountEqualTo(account);
		//ִ�в�ѯ
		List<Admin> adminList = adminMapper.selectByExample(adminExample);
		//�жϲ�ѯ����Ƿ�Ϊ�գ�����Ϊ�����ж������Ƿ���ȷ
		if(adminList == null || adminList.size() == 0 
				|| StringUtils.isBlank(account) || StringUtils.isBlank(password)
				|| !adminList.get(0).getApassword().equals(DigestUtils.md5DigestAsHex(password.getBytes())))
			return Result.build(500, "�˺Ż��������!");
		if(adminList.get(0).getAactive() == 0)
            return Result.build(500, "���˺�δ����!");
        if(adminList.get(0).getAenable() == 0)
            return Result.build(500, "���˺��ѱ�����!");
		//�����ȷ��������
		return Result.OK(adminList.get(0));
	}

	@Override
	public Result adminChangePassword(Admin admin, String newPassword) {
		//��ȡid��Ӧ�Ĺ���Ա����
		Admin checkAdmin = adminMapper.selectByPrimaryKey(admin.getAid());
		//�ж�ԭ�����Ƿ���ȷ
		if(checkAdmin.getApassword().equals(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()))) {
			//����ȷ��ִ���޸�
			//�����޸Ķ���
			Admin a = new Admin();
			a.setAid(admin.getAid());
			a.setApassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
			//ִ��ѡ�����޸�
			adminMapper.updateByPrimaryKeySelective(a);
		} else {
			//������ȷ���׳��쳣
			throw new XKException("ԭ�����������");
		}
		return Result.OK();
	}

	@Override
	public Result adminUpdateInfo(Admin admin) {
		//�����ֵ
		ClearBlankUtil.clearStringBlank(admin);

		//��֤�����Ƿ��Ѿ�����
		Admin checkAdmin = superService.selectAdminByMail(admin.getAmail());
		if(checkAdmin != null && !checkAdmin.getAid().equals(admin.getAid())) {
			if(checkAdmin.getAactive() == 0) {
				//���Ѿ������Ҳ��ǵ�ǰ�༭�˺���δ������ɾ�����ظ���
				adminMapper.deleteByPrimaryKey(checkAdmin.getAid());
			} else {
				//���Ѿ������Ҳ��ǵ�ǰ�༭�˺����Ѽ������׳��쳣
				throw new XKException("�������ѱ�ע��");
			}
		}
		//��������Ԫ�ؽ��и��¶�������ȫ����
		adminMapper.updateByPrimaryKeySelective(admin);
		//���سɹ����
		return Result.OK();
	}

	@Override
	public Result adminRegister(Admin admin) {
		//��ѯ����Ա�˺��Ƿ��Ѿ�����
		Admin a = superService.selectAdminByAccount(admin.getAaccount());
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
		a = superService.selectAdminByMail(admin.getAmail());
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
		admin.setAenable(0);
		admin.setAactive(0);
		admin.setAlevel(2);
		admin.setAgender(2);
		admin.setAcreatedate(new Date());
		admin.setAheadimg("default.jpg");
		admin.setAname(admin.getAaccount());
		//���������벢����
		String activeCode = UUID.randomUUID().toString().replace("-", "");
		admin.setAactivecode(activeCode);
		//ִ������MD5����
		admin.setApassword(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()));

		//ִ�в���
		adminMapper.insert(admin);

		//�����߳�ִ�з����ʼ�
		new Thread(new Runnable() {
			@Override
			public void run() {
				//���ͼ����ʼ�
				String mailContent = "��ӭ�����ǿդλ���, �������ǿդξۺ�������ע���˺�,�����·����Ӽ����˺�!<br>" +
						"<a href='http://localhost:8082/xk/activeAccount/" + activeCode + "'>http://localhost:8082/xk/activeAccount/" + activeCode + "</a>";
				try {
					SendMailQQ.sendMail("738272815@qq.com", admin.getAmail(), "�ǿդξۺ�-�˺�����", mailContent);
				} catch (Exception e) {
					//ɾ��ע���¼
					adminMapper.deleteByPrimaryKey(superService.selectAdminByAccount(admin.getAaccount()).getAid());
					throw new XKException("�����ʼ�����ʧ��, ����������!");
				}
			}
		}).start();
		return Result.OK("http://mail." + admin.getAmail().substring(admin.getAmail().lastIndexOf("@") + 1));
	}

	@Override
	public Result adminActive(String activeCode) {
		//������ѯģ��
		AdminExample adminExample = new AdminExample();
		Criteria criteria = adminExample.createCriteria();

		//��Ӳ�ѯ����
		criteria.andAactivecodeEqualTo(activeCode);
		//ִ�в�ѯ
		List<Admin> admins = adminMapper.selectByExample(adminExample);

		if(admins.size() == 0)
			throw new XKException("��Ч�ļ�����");
		if(admins.get(0).getAactive() == 1)
			throw new XKException("�ü������ѱ�ʹ��");

		Admin admin = new Admin();
		admin.setAid(admins.get(0).getAid());
		admin.setAenable(1);
		admin.setAactive(1);

		//���¼���״̬
		adminMapper.updateByPrimaryKeySelective(admin);

		return Result.OK(admins.get(0).getAaccount());
	}
}
