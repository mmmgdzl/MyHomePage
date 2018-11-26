package com.mmmgdzl.web.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * �ü��������ڽ������ļ��е�ȫ�ֳ�ʼ����������applicationContext����
 * @author mmmgdzl
 */
public class InitApplicationContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Properties properties = new Properties();
		// ʹ��ClassLoader����resource.properties�����ļ����ɶ�Ӧ��������
		InputStream in = InitApplicationContextListener.class.getClassLoader()
				.getResourceAsStream("conf/resource.properties");
		// ʹ��properties�������������
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//��ȡkey��Ӧ��valueֵ
		//����Դ������·�����õ�applicationContext����
		String imageServer = properties.getProperty("RESOURCE_SERVER");
		arg0.getServletContext().setAttribute("resourceServer", imageServer);
	}

}
