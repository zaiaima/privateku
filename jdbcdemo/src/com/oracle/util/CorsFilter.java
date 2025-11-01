package com.oracle.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CorsFilter
 */
@WebFilter(filterName = "/CorsFilter", urlPatterns="/*")
public class CorsFilter implements Filter {

    public CorsFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse)res;
		
		response.setContentType("text/html; charset=UTF-8");
        // 设置允许跨域的域，*代表允许所有域，也可以设置特定的域
//	    response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
	    // 允许的方法
	    response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE");
	    // 允许的头信息字段
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
