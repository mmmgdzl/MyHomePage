package com.mmmgdzl.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * ͨ�ñ���������
 * 
 */
public class GenericEncodingFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ת��Ϊ��Э����ض���
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		// ��request��װ��ǿ
		HttpServletRequest myrequest = new MyRequest(httpServletRequest);
		chain.doFilter(myrequest, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}

// �Զ���request����
class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	private boolean hasEncode;

	public MyRequest(HttpServletRequest request) {
		super(request);// super����д
		this.request = request;
	}

	// ����Ҫ��ǿ���� ���и���
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getParameterMap() {
		// �Ȼ������ʽ
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			// post����
			try {
				// ����post����
				request.setCharacterEncoding("utf-8");
				return request.getParameterMap();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else if (method.equalsIgnoreCase("get")) {
			// get����
			Map<String, String[]> parameterMap = request.getParameterMap();
			if (!hasEncode) { // ȷ��get�ֶ������߼�ֻ����һ��
				for (String parameterName : parameterMap.keySet()) {
					String[] values = parameterMap.get(parameterName);
					if (values != null) {
						for (int i = 0; i < values.length; i++) {
							try {
								// ����get����
								values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode = true;
			}
			return parameterMap;
		}

		return super.getParameterMap();
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getParameter(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		return values[0]; // ȡ�ز����ĵ�һ��ֵ
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}

}