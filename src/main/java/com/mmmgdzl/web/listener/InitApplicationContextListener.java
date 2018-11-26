package com.mmmgdzl.web.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 该监听器用于将配置文件中的全局初始化变量放入applicationContext域中
 * @author mmmgdzl
 */
public class InitApplicationContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Properties properties = new Properties();
		// 使用ClassLoader加载resource.properties配置文件生成对应的输入流
		InputStream in = InitApplicationContextListener.class.getClassLoader()
				.getResourceAsStream("conf/resource.properties");
		// 使用properties对象加载输入流
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//获取key对应的value值
		//将资源服务器路径设置到applicationContext域中
		String imageServer = properties.getProperty("RESOURCE_SERVER");
		arg0.getServletContext().setAttribute("resourceServer", imageServer);
	}

}
