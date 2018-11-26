package com.mmmgdzl.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 该类用于统计总访问次数
 * @author mmmgdzl
 *
 */

public class RequestCountListener implements ServletRequestListener {
	
	//总访问次数名
	public final String TOTAL_REQUEST = "TOTAL_REQUEST";
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		servletContext.setAttribute(TOTAL_REQUEST, servletContext.getAttribute(TOTAL_REQUEST) == null ? 1 
			: Integer.parseInt(servletContext.getAttribute(TOTAL_REQUEST).toString()) + 1);
	}

}
