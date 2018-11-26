package com.mmmgdzl.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 该类用于统计当前在线人数以及统计总访问量
 * @author mmmgdzl
 *
 */
public class VisitorCountListener implements HttpSessionListener {
	
	//总访问人数名
	public final String TOTAL_VISIT = "TOTAL_VISITOR";
	//当前在线人数名
	public final String CURRENT_VISIT = "CURRENT_VISITOR";

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		//总访问量+1
		servletContext.setAttribute(TOTAL_VISIT, 
				servletContext.getAttribute(TOTAL_VISIT) == null ? 1 
						: Integer.parseInt(servletContext.getAttribute(TOTAL_VISIT).toString()) + 1);
		//当前在线人数+1
		servletContext.setAttribute(CURRENT_VISIT, 
				servletContext.getAttribute(CURRENT_VISIT) == null ? 1 
						: Integer.parseInt(servletContext.getAttribute(CURRENT_VISIT).toString()) + 1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		//当前在线人数-1
		servletContext.setAttribute(CURRENT_VISIT, 
				servletContext.getAttribute(CURRENT_VISIT) == null ? 0 
						: Integer.parseInt(servletContext.getAttribute(CURRENT_VISIT).toString()) - 1);
	}

}
