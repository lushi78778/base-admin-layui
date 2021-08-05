package hui.base.interceptor;

import cn.hutool.json.JSON;
import freemarker.template.utility.StringUtil;
import hui.base.entity.User;
import hui.base.util.MenuUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截器
 *
 * @author hui
 * @date 2021-08-03 11:17:00
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		if (user == null) {
			//用户还未登录或者session失效,重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}
}
