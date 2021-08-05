package hui.base.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import hui.base.bean.Result;
import hui.base.bean.RetCode;
import hui.base.dao.UserDao;
import hui.base.entity.Menu;
import hui.base.entity.User;
import hui.base.util.MenuUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 系统控制器
 *
 * @author hui
 * @date 2021-07-29 09:12:28
 */
@RestController
public class SystemController {

	@Resource
	private UserDao userDao;

	/**
	 * 用户登录接口
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @param captcha  验证码
	 * @param session  HttpSession对象
	 * @return 统一返回值JSON
	 */
	@PostMapping("/login")
	public Result login(String username, String password, String captcha, HttpSession session) {
		//验证码错误
		String code = session.getAttribute("code").toString();
		if (!code.equalsIgnoreCase(captcha)) {
			return new Result(RetCode.CAPTCHA_ERROR);
		}
		//查询用户
		User user = userDao.findUserByUsername(username);
		//用户不存在
		if (user == null) {
			return new Result(RetCode.USER_NOT_EXIST);
		}
		//密码错误
		if (!user.getPassword().equals(password)) {
			return new Result(RetCode.PASSWORD_ERROR);
		}
		//登录成功，将用户信息和菜单保存到session
		List<Menu> menus = user.getRole().get(0).getMenu();
		session.setAttribute("USER", user);
		session.setAttribute("menus", MenuUtil.toTree(menus, 0));
		return new Result(RetCode.LOGIN_SUCCESS,"dashboard");
	}

	/**
	 * 退出登录
	 *
	 * @param session  HttpSession对象
	 * @param response HttpServletResponse对象
	 * @throws IOException IO异常
	 */
	@GetMapping("/logout")
	public void logout(HttpSession session, HttpServletResponse response) throws IOException {
		session.setAttribute("USER", null);
		response.sendRedirect("/login");
	}

	/**
	 * 验证码接口
	 *
	 * @param session  HttpSession对象
	 * @param response HttpServletResponse对象
	 * @throws IOException IO异常
	 */
	@GetMapping("/captcha")
	public void captcha(HttpSession session, HttpServletResponse response) throws IOException {
		//生成验证码对象
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(120, 40, 4, 50);
		//将验证码保存到session
		String code = captcha.getCode();
		session.setAttribute("code", code);
		//将验证码通过输出流返回到前端
		OutputStream os = response.getOutputStream();
		captcha.write(os);
	}
}
