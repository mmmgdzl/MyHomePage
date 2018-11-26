package com.mmmgdzl.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ��������ͳ�Ƶ�ǰ���������Լ�ͳ���ܷ�����
 * @author mmmgdzl
 *
 */
public class VisitorCountListener implements HttpSessionListener {
	
	//�ܷ���������
	public final String TOTAL_VISIT = "TOTAL_VISITOR";
	//��ǰ����������
	public final String CURRENT_VISIT = "CURRENT_VISITOR";

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		//�ܷ�����+1
		servletContext.setAttribute(TOTAL_VISIT, 
				servletContext.getAttribute(TOTAL_VISIT) == null ? 1 
						: Integer.parseInt(servletContext.getAttribute(TOTAL_VISIT).toString()) + 1);
		//��ǰ��������+1
		servletContext.setAttribute(CURRENT_VISIT, 
				servletContext.getAttribute(CURRENT_VISIT) == null ? 1 
						: Integer.parseInt(servletContext.getAttribute(CURRENT_VISIT).toString()) + 1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		//��ǰ��������-1
		servletContext.setAttribute(CURRENT_VISIT, 
				servletContext.getAttribute(CURRENT_VISIT) == null ? 0 
						: Integer.parseInt(servletContext.getAttribute(CURRENT_VISIT).toString()) - 1);
	}

}
