package com.mmmgdzl.web.listener;

import com.mmmgdzl.utils.ConstantValueUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 该类用于统计总访问次数
 * @author mmmgdzl
 *
 */

public class RequestCountListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();
		servletContext.setAttribute(ConstantValueUtil.TOTAL_REQUEST, servletContext.getAttribute(ConstantValueUtil.TOTAL_REQUEST) == null ? 1
			: Integer.parseInt(servletContext.getAttribute(ConstantValueUtil.TOTAL_REQUEST).toString()) + 1);
	}

}
