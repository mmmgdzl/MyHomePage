package com.mmmgdzl.web.interceptor;

import com.mmmgdzl.pojo.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的地址
        String uri = request.getRequestURI();
       //获取当前登录的管理员
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(uri.indexOf("xk/protect") > 0 && admin == null) {
            return false;
        }
        if(uri.indexOf("xk/super") > 0 && (admin == null || admin.getAlevel() > 0)) {
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
