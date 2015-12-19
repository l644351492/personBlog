package com.myblog.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截器bean编写
 * 当验证用户未登录的时候会弹出警告框，并自动跳转到用户登录页面
 * @author 2012216954
 *
 */
@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		response.setHeader("content-type","text/html;charset=UTF-8");

		// 后台session控制
		Object obj = request.getSession().getAttribute("user");
		if (null == obj) {
			// 未登录
			PrintWriter out = response.getWriter();
			StringBuilder builder = new StringBuilder();
			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
			builder.append("alert(\"页面过期，请重新登录\");");
			builder.append("window.top.location.href=\"");
			builder.append(request.getContextPath());
			builder.append("/user/login");
			builder.append("\"</script>");
			out.print(builder.toString());
			out.close();
			return false;
		}

		return super.preHandle(request, response, handler);
	}
}
