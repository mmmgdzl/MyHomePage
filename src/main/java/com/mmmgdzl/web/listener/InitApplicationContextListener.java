package com.mmmgdzl.web.listener;

import com.mmmgdzl.utils.ConstantValueUtil;
import com.mmmgdzl.web.task.WhiteVisitCountToSQLAndLogTask;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 该监听器用于将配置文件中的全局初始化变量放入applicationContext域中
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
			//获取key对应的value值
			//将资源服务器路径设置到applicationContext域中
			String resourceServer = config.getString("RESOURCE_SERVER");
			arg0.getServletContext().setAttribute("resourceServer", resourceServer);
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
