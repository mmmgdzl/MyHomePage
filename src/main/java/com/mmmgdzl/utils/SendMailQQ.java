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
*JavaMail发送邮件:前提是QQ邮箱里帐号设置要开启POP3/SMTP协议
*/
public class SendMailQQ {
	
	private static Properties prop;
	
	static {
		prop = new Properties();
		// 开启debug调试，以便在控制台查看
		prop.setProperty("mail.debug", "true"); 
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");
		// 开启SSL加密，否则会失败
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
	 * 发送邮件
	 * @param sendAddress 发送者地址
	 * @param receiveAddress 接收者地址
	 * @param subject 邮件主题
	 * @param text 邮件正文
	 * @throws Exception 
	 */
	public static void sendMail(String sendAddress, String receiveAddress, String subject,
			String text) throws Exception {
		// 创建session
		Session session = Session.getInstance(prop);
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		ts.connect("smtp.qq.com","738272815", "udqeobjqrztlbebg");//后面的字符是授权码
		// 创建邮件
		Message message = createSimpleMail(session, sendAddress, receiveAddress, subject, text);
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/**
	* @Method: createSimpleMail
	* @Description: 创建一封只包含文本的邮件
	*/
	private static MimeMessage createSimpleMail(Session session, String sendAddress, 
			String receiveAddress, String subject, String text) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(sendAddress));//"738272815@qq.com"
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveAddress));//"1400820029@qq.com"
		// 邮件的标题
		message.setSubject(subject);//"JavaMail测试"
		// 邮件的文本内容
		message.setContent(text, "text/html;charset=UTF-8");//"傻宁"
		// 返回创建好的邮件对象
		return message;
	}
}