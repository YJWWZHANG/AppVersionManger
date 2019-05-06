package com.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 编码过滤器， 设置当前系统的编码。
 * 
 * @author hotent
 * 
 */
public class EncodingFilter implements Filter
{

	private String encoding = "UTF-8";
	private String contentType = "text/html;charset=UTF-8";

	@Override
	public void destroy()
	{

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse httpresponse,
			FilterChain chain) throws IOException, ServletException
	{
		long start_time=System.currentTimeMillis();
		HttpServletResponse response=(HttpServletResponse)httpresponse;
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		response.setContentType(contentType);
		
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", -1);
        long run_time=System.currentTimeMillis();
        System.out.println("【编码耗时】="+(run_time-start_time));
		chain.doFilter(request, response);
		long end_time=System.currentTimeMillis();
		System.out.println("【编码耗时】="+(end_time-start_time));
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException
	{
		String _encoding = config.getInitParameter("encoding");
		String _contentType = config.getInitParameter("contentType");
		// String ext=config.getInitParameter("ext");
		if (_encoding != null)
			encoding = _encoding;
		if (_contentType != null)
			contentType = _contentType;

	}

}
