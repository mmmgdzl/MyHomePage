package com.mmmgdzl.web.interceptor;

import com.mmmgdzl.pojo.Admin;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //��ȡ����ĵ�ַ
        String uri = request.getRequestURI();
        //��ȡ��ǰ��¼�Ĺ���Ա
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(uri.indexOf("xk/protect") > 0 && admin == null) {
            visitFalse(modelAndView);
        } else if(uri.indexOf("xk/admin") > 0 && (admin == null || admin.getAlevel() > 1)) {
            visitFalse(modelAndView);
        } else if(uri.indexOf("xk/super") > 0 && (admin == null || admin.getAlevel() > 0)) {
            visitFalse(modelAndView);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {}

    //����ʧ�ܵĴ���
    private void visitFalse(ModelAndView modelAndView) {
        //���÷���ʧ�ܵĵ�¼ҳ����ת��־
        if(modelAndView != null)
            modelAndView.setViewName("redirect:/xk/login?visitFalse=true");
    }
}
