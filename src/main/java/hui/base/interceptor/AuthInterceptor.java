package hui.base.interceptor;

import hui.base.entity.Menu;
import hui.base.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 权限统一管理拦截器
 *
 * @author hui
 * @date 2021-08-03 11:18:00
 */
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		String contextPath = request.getContextPath();
		String requestUri = request.getRequestURI();
		String current = requestUri.substring(contextPath.length() + 1);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER");
		List<Menu> menus = user.getRole().get(0).getMenu();
		for (Menu menu : menus) {
			String path = menu.getPath();
			if (path.equalsIgnoreCase(current)) {
				return true;
			}
		}
		response.sendError(403);
		return false;
	}
}
