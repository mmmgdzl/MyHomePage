package com.mmmgdzl.web.listener;

import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.web.task.WhiteVisitCountToSQLAndLogTask;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * �ü��������ڽ������ļ��е�ȫ�ֳ�ʼ����������applicationContext����
 * @author mmmgdzl
 */
public class InitApplicationContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(WhiteVisitCountToSQLAndLogTask.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String profilepath = InitApplicationContextListener.class.getResource("/").getPath()+"conf/resource.properties";
		try
		{
			PropertiesConfiguration config  = new PropertiesConfiguration(profilepath);
			//��ȡkey��Ӧ��valueֵ
			//����Դ������·�����õ�applicationContext����
			String resourceServer = config.getString("RESOURCE_SERVER");
			arg0.getServletContext().setAttribute("resourceServer", resourceServer);
			//������վ�ķ�����
			//���ַ��ʴ���
			String totalRequest = config.getString(ConstantValueUtil.TOTAL_REQUEST);
			arg0.getServletContext().setAttribute(ConstantValueUtil.TOTAL_REQUEST, totalRequest);
			//���ַ�������
			String totalVisitor = config.getString(ConstantValueUtil.TOTAL_VISITOR);
			arg0.getServletContext().setAttribute(ConstantValueUtil.TOTAL_VISITOR, totalVisitor);
		} catch(Exception e) {
			logger.error("��ʼ����վ����ʧ��");
			e.printStackTrace();
		}
	}

}
