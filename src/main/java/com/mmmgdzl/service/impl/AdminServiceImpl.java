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
		//�����˺Ų�ѯ����Ա
		Admin admin = superService.selectAdminByAccount(account);
		//�жϲ�ѯ����Ƿ�Ϊ�գ�����Ϊ�����ж������Ƿ�Ϊ�����Ƿ���ȷ
		if(admin == null || !admin.getApassword().equals(DigestUtils.md5DigestAsHex(password.getBytes())))
			throw new XKException("�˺Ż��������");
		if(admin.getAactive() == 0)
			throw new XKException("���˺�δ����");
        if(admin.getAenable() == 0)
			throw new XKException("���˺��ѱ�����");
		//�����ȷ���ع���Ա����
		return admin;
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
				throw new XKException("���˺ű�ע��");
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
				throw new XKException("�������ѱ�ע��");
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
						"<a href='http://" + ACTIVE_MAIL_WEB_SITE + "/xk/activeAccount/" + activeCode + "'>http://" + ACTIVE_MAIL_WEB_SITE + "/xk/activeAccount/" + activeCode + "</a>";
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
		//�����ѯ���Ϊ��
		if(admins.size() == 0)
			throw new XKException("��Ч�ļ�����");
		//�����ѯ�����û��ѱ�����
		if(admins.get(0).getAactive() == 1)
			throw new XKException("�ü������ѱ�ʹ��");
		//���¼���״̬
		Admin admin = new Admin();
		admin.setAid(admins.get(0).getAid());
		admin.setAenable(1);
		admin.setAactive(1);
		adminMapper.updateByPrimaryKeySelective(admin);

		//���سɹ����(�����û��˺�)
		return Result.OK(admins.get(0).getAaccount());
	}

	@Override
	public Result adminChangePassword(Admin admin, String newPassword) {
		//��ȡid��Ӧ�Ĺ���Ա����
		Admin checkAdmin = adminMapper.selectByPrimaryKey(admin.getAid());
		//�ж�ԭ�����Ƿ���ȷ
		if(!checkAdmin.getApassword().equals(DigestUtils.md5DigestAsHex(admin.getApassword().getBytes()))) {
			//������ȷ���׳��쳣
			throw new XKException("ԭ�����������");
		}
		//����ȷ��ִ���޸�
		//�����޸Ķ���
		Admin a = new Admin();
		a.setAid(admin.getAid());
		//MD5��������
		a.setApassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		//ִ��ѡ�����޸�
		adminMapper.updateByPrimaryKeySelective(a);
		//���سɹ����
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
		//��������Ԫ�ؽ��и���
		adminMapper.updateByPrimaryKeySelective(admin);
		//���سɹ����
		return Result.OK();
	}
}
