package com.mmmgdzl.web.listener;

import com.mmmgdzl.utils.ConstantValueUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * �ü���������ͳ�Ƶ�ǰ���������Լ�ͳ���ܷ�����
 * @author mmmgdzl
 *
 */
public class VisitorCountListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		//�ܷ�����+1
		servletContext.setAttribute(ConstantValueUtil.TOTAL_VISITOR,
				servletContext.getAttribute(ConstantValueUtil.TOTAL_VISITOR) == null ? 1
						: Integer.parseInt(servletContext.getAttribute(ConstantValueUtil.TOTAL_VISITOR).toString()) + 1);
		//��ǰ��������+1
		servletContext.setAttribute(ConstantValueUtil.CURRENT_VISITOR,
				servletContext.getAttribute(ConstantValueUtil.CURRENT_VISITOR) == null ? 1
						: Integer.parseInt(servletContext.getAttribute(ConstantValueUtil.CURRENT_VISITOR).toString()) + 1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext servletContext = arg0.getSession().getServletContext();
		//��ǰ��������-1
		servletContext.setAttribute(ConstantValueUtil.CURRENT_VISITOR,
				servletContext.getAttribute(ConstantValueUtil.CURRENT_VISITOR) == null ? 0
						: Integer.parseInt(servletContext.getAttribute(ConstantValueUtil.CURRENT_VISITOR).toString()) - 1);
	}

}
