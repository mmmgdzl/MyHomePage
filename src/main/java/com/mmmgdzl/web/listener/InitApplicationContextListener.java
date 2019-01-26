package com.mmmgdzl.web.listener;

import com.mmmgdzl.service.DataIndexService;
import com.mmmgdzl.utils.ConstantValueUtil;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.aspectj.apache.bcel.classfile.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * �ü��������ڽ������ļ��е�ȫ�ֳ�ʼ����������applicationContext����
 * @author mmmgdzl
 */

@Component
public class InitApplicationContextListener implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(InitApplicationContextListener.class);

    @Autowired
	private DataIndexService dataIndexService;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getServletContext())
				.getAutowireCapableBeanFactory().autowireBean(this);//������һ��
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
			String INDEX_BACKGROUND_MUSIC_FILE_NAME = dataIndexService.getDataIndexByDiname(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME).getDivalue();
			arg0.getServletContext().setAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, INDEX_BACKGROUND_MUSIC_FILE_NAME);
			//��ʼ����ҳ������Ƶ�ļ�
			String INDEX_BACKGROUND_VIDEO_FILE_NAME = dataIndexService.getDataIndexByDiname(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME).getDivalue();
			arg0.getServletContext().setAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, INDEX_BACKGROUND_VIDEO_FILE_NAME);

			//������վ�ķ�����
			//���ַ��ʴ���
			String totalRequest = dataIndexService.getDataIndexByDiname(ConstantValueUtil.TOTAL_REQUEST).getDivalue();
			arg0.getServletContext().setAttribute(ConstantValueUtil.TOTAL_REQUEST, totalRequest);
			//���ַ�������
			String totalVisitor = dataIndexService.getDataIndexByDiname(ConstantValueUtil.TOTAL_VISITOR).getDivalue();
			arg0.getServletContext().setAttribute(ConstantValueUtil.TOTAL_VISITOR, totalVisitor);
		} catch(Exception e) {
			logger.error("��ʼ����վ����ʧ��");
			e.printStackTrace();
		}
	}

}
