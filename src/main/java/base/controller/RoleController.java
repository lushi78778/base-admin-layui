package base.controller;

import base.bean.Result;
import base.bean.RetCode;
import base.dao.RoleDao;
import base.entity.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色管理控制器
 *
 * @author hui
 * @date 2021-07-29 09:22:32
 */
@RestController
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleDao roleDao;

	/**
	 * 查询所有角色
	 *
	 * @return 统一返回值JSON
	 */
	@PostMapping("/list")
	public Result list() {
		List<Role> roles = roleDao.findAll();
		return new Result(RetCode.OK, roles, roles.size());
	}

	/**
	 * 添加/修改角色
	 *
	 * @param role Role对象
	 * @return 统一返回值JSON
	 */
	@PostMapping("/save")
	public Result save(Role role) {
		roleDao.save(role);
		return new Result(RetCode.OK);
	}

	/**
	 * 根据ID删除角色
	 *
	 * @param id 角色ID
	 * @return 统一返回值JSON
	 */
	@PostMapping("/delete")
	public Result delete(Integer id) {
		roleDao.deleteById(id);
		return new Result(RetCode.OK);
	}

}
