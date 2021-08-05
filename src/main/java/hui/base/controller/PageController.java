package hui.base.controller;

import hui.base.dao.MenuDao;
import hui.base.dao.RoleDao;
import hui.base.entity.Menu;
import hui.base.entity.Role;
import hui.base.util.MenuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 页面控制器
 *
 * @author hui
 * @date 2021-07-29 09:12:38
 */
@Controller
public class PageController {

	@Resource
	private RoleDao roleDao;

	@Resource
	private MenuDao menuDao;

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
		return "admin/dashboard";
	}

	/**
	 * 菜单管理页面
	 *
	 * @return 页面
	 */
	@GetMapping("/menu")
	public String menu(Model model) {
		List<Menu> menus = menuDao.findAll();
		model.addAttribute("menus", MenuUtil.toTree(menus, 0));
		return "admin/menu";
	}

	/**
	 * 角色管理页面
	 *
	 * @return 页面
	 */
	@GetMapping("/role")
	public String role() {
		return "admin/role";
	}

	/**
	 * 用户管理页面
	 *
	 * @return 页面
	 */
	@GetMapping("/user")
	public String user(Model model) {
		List<Role> roles = roleDao.findAll();
		model.addAttribute("roles", roles);
		return "admin/user";
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
