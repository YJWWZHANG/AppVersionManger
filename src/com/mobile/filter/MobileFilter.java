package com.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mobile.model.ResultModel;
import com.mobile.token.util.TokenUtil;

/**
 * 主要处理 过滤非法 用户 获取 用户信息
 * 
 * @author fengjunming_t
 * 
 */
public class MobileFilter implements Filter {

	private Logger logger = Logger.getLogger(MobileFilter.class);
	private CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	private String exclude_maping = "";
    private String contentType="text/html;charset=UTF-8";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
		long start_time = System.currentTimeMillis();
		ResultModel rmToken = new ResultModel();
		String[] anonymousUrls = this.exclude_maping.split(";");
		for (int i = 0; i < anonymousUrls.length; i++) {
			if (((HttpServletRequest) request).getServletPath().indexOf(
					anonymousUrls[i]) >= 0) {
				filter.doFilter(request, response);
				return;
			}
		}
		String contentType=request.getContentType()==null?"":request.getContentType();//表单类型 
		String tokenid="";
		if(!"".equals(contentType)&&contentType.contains("multipart/form-data")){
			MultipartHttpServletRequest multiReq = multipartResolver.resolveMultipart((HttpServletRequest) request);
			tokenid=multiReq.getParameter("token") == null ? "" : multiReq
						.getParameter("token");
			request=multiReq;//文件 类型 需要 把 multiReq 参数 赋值 给 request对象 
		}else{
			// 获取令牌
			 tokenid = request.getParameter("token") == null ? "" : request
					.getParameter("token");
		}
		// 令牌为空
		if ("".equals(tokenid)) {
			logger.info("过滤器拦截tokne值为空");
			response.setContentType("text/html;charset=UTF-8");
			response
					.getWriter()
					.println(
							"{\"code\":\"\",\"data\":\"\",\"errcode\":\"40009\",\"msg\":\"令牌不能为空，请联系管理员!\",\"status\":\"failure\",\"timestamp\":1418701524725}");
		return;
		}
		logger.debug("tokenid===="+tokenid);
		rmToken = TokenUtil.getTokenResultModel(TokenUtil.getTokenMap(tokenid));

		if ("failure".equals(rmToken.getStatus())) {
			JSONObject json = JSONObject.fromObject(rmToken);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println(json.toString());
			return;
		} else {
			long run_time = System.currentTimeMillis();
			filter.doFilter(request, response);
			long end_time = System.currentTimeMillis();
			logger.info("token过滤结束耗时==" + (end_time - start_time));
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.exclude_maping = arg0.getInitParameter("exclude_maping");
		this.exclude_maping = (this.exclude_maping == null ? ""
				: this.exclude_maping);
	}

}
