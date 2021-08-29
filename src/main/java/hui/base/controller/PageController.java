package hui.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面控制器
 *
 * @author hui
 * @date 2021-07-29 09:12:38
 */
@Controller
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	/**
	 * 登录页面
	 *
	 * @return 页面
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * 系统首页仪表盘
	 *
	 * @return 页面
	 */
	@GetMapping("/dashboard")
	public String dashboard() {
		return "system/dashboard";
	}

	/**
	 * 菜单管理页面
	 *
	 * @return 页面
	 */
	@GetMapping("/menu")
	public String menu() {
		return "menu/list";
	}

	/**
	 * 角色管理页面
	 *
	 * @return 页面
	 */
	@GetMapping("/role")
	public String role() {
		return "role/list";
	}

	/**
	 * 用户管理页面
	 *
	 * @return 页面
	 */
	@GetMapping("/user")
	public String user() {
		return "user/list";
	}

	/**
	 * 系统设置页面
	 *
	 * @return 页面
	 */
	@GetMapping("/setting")
	public String setting() {
		return "system/setting";
	}

	/**
	 * 用户个人信息页面
	 *
	 * @return 页面
	 */
	@GetMapping("/profile")
	public String profile() {
		return "system/profile";
	}

	/**
	 * 用户修改密码页面
	 *
	 * @return 页面
	 */
	@GetMapping("/password")
	public String password() {
		return "system/password";
	}

	/**
	 * 404错误页面
	 *
	 * @return 页面
	 */
	@GetMapping("/404")
	public String e404() {
		return "error/404";
	}

	/**
	 * 403错误页面
	 *
	 * @return 页面
	 */
	@GetMapping("/403")
	public String e403() {
		return "error/403";
	}

	/**
	 * 500错误页面
	 *
	 * @return 页面
	 */
	@GetMapping("/500")
	public String e500() {
		return "error/500";
	}
}
