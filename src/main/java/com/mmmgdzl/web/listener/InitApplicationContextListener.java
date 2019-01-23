package com.mmmgdzl.web.listener;

import com.mmmgdzl.utils.ConstantValueUtil;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.aspectj.apache.bcel.classfile.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * �ü��������ڽ������ļ��е�ȫ�ֳ�ʼ����������applicationContext����
 * @author mmmgdzl
 */
public class InitApplicationContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(InitApplicationContextListener.class);

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

			//��ʼ����ҳ����
			//��ʼ����ҳ���������ļ�
			String INDEX_BACKGROUND_MUSIC_FILE_NAME = config.getString(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME);
			arg0.getServletContext().setAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, INDEX_BACKGROUND_MUSIC_FILE_NAME);
			//��ʼ����ҳ������Ƶ�ļ�
			String INDEX_BACKGROUND_VIDEO_FILE_NAME = config.getString(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME);
			arg0.getServletContext().setAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, INDEX_BACKGROUND_VIDEO_FILE_NAME);

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
