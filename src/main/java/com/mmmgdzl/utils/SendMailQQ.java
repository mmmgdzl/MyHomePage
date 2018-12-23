package com.mmmgdzl.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;

/**
*JavaMail�����ʼ�:ǰ����QQ�������ʺ�����Ҫ����POP3/SMTPЭ��
*/
public class SendMailQQ {
	
	private static Properties prop;
	
	static {
		prop = new Properties();
		// ����debug���ԣ��Ա��ڿ���̨�鿴
		prop.setProperty("mail.debug", "true"); 
		// �����ʼ�������������
		prop.setProperty("mail.host", "smtp.qq.com");
		// ���ͷ�������Ҫ�����֤
		prop.setProperty("mail.smtp.auth", "true");
		// �����ʼ�Э������
		prop.setProperty("mail.transport.protocol", "smtp");
		// ����SSL���ܣ������ʧ��
		MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);
	}
	
	/**
	 * �����ʼ�
	 * @param sendAddress �����ߵ�ַ
	 * @param receiveAddress �����ߵ�ַ
	 * @param subject �ʼ�����
	 * @param text �ʼ�����
	 * @throws Exception 
	 */
	public static void sendMail(String sendAddress, String receiveAddress, String subject,
			String text) throws Exception {
		// ����session
		Session session = Session.getInstance(prop);
		// ͨ��session�õ�transport����
		Transport ts = session.getTransport();
		// �����ʼ����������������ͣ��ʺţ���Ȩ��������루����ȫ��
		ts.connect("smtp.qq.com","738272815", "udqeobjqrztlbebg");//������ַ�����Ȩ��
		// �����ʼ�
		Message message = createSimpleMail(session, sendAddress, receiveAddress, subject, text);
		// �����ʼ�
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/**
	* @Method: createSimpleMail
	* @Description: ����һ��ֻ�����ı����ʼ�
	*/
	private static MimeMessage createSimpleMail(Session session, String sendAddress, 
			String receiveAddress, String subject, String text) throws Exception {
		// �����ʼ�����
		MimeMessage message = new MimeMessage(session);
		// ָ���ʼ��ķ�����
		message.setFrom(new InternetAddress(sendAddress));//"738272815@qq.com"
		// ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveAddress));//"1400820029@qq.com"
		// �ʼ��ı���
		message.setSubject(subject);//"JavaMail����"
		// �ʼ����ı�����
		message.setContent(text, "text/html;charset=UTF-8");//"ɵ��"
		// ���ش����õ��ʼ�����
		return message;
	}
}