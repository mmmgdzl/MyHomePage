package com.mmmgdzl.web.listener;

import com.mmmgdzl.utils.ConstantValueUtil;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.aspectj.apache.bcel.classfile.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 该监听器用于将配置文件中的全局初始化变量放入applicationContext域中
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
			//获取key对应的value值
			//将资源服务器路径设置到applicationContext域中
			String resourceServer = config.getString("RESOURCE_SERVER");
			arg0.getServletContext().setAttribute("resourceServer", resourceServer);

			//初始化主页设置
			//初始化主页背景音乐文件
			String INDEX_BACKGROUND_MUSIC_FILE_NAME = config.getString(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME);
			arg0.getServletContext().setAttribute(ConstantValueUtil.INDEX_BACKGROUND_MUSIC_FILE_NAME, INDEX_BACKGROUND_MUSIC_FILE_NAME);
			//初始化主页背景视频文件
			String INDEX_BACKGROUND_VIDEO_FILE_NAME = config.getString(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME);
			arg0.getServletContext().setAttribute(ConstantValueUtil.INDEX_BACKGROUND_VIDEO_FILE_NAME, INDEX_BACKGROUND_VIDEO_FILE_NAME);

			//重现网站的访问量
			//重现访问次数
			String totalRequest = config.getString(ConstantValueUtil.TOTAL_REQUEST);
			arg0.getServletContext().setAttribute(ConstantValueUtil.TOTAL_REQUEST, totalRequest);
			//重现访问人数
			String totalVisitor = config.getString(ConstantValueUtil.TOTAL_VISITOR);
			arg0.getServletContext().setAttribute(ConstantValueUtil.TOTAL_VISITOR, totalVisitor);
		} catch(Exception e) {
			logger.error("初始化网站属性失败");
			e.printStackTrace();
		}
	}

}
