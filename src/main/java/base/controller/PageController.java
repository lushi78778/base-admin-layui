package base.controller;

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
}
