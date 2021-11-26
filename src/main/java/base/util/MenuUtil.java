package base.util;

import base.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形菜单工具类
 *
 * @author hui
 * @date 2021-07-30 22:53:11
 */
public class MenuUtil {

	/**
	 * 将Menu集合对象转换为树形结构
	 *
	 * @param menus Menu集合对象
	 * @param pid   父级菜单ID
	 * @return 树形Menu集合对象
	 */
	public static List<Menu> toTree(List<Menu> menus, Integer pid) {
		List<Menu> tree = new ArrayList<>();
		for (Menu parent : menus) {
			if (parent.getPid().equals(pid)) {
				tree.add(findChildren(menus, parent));
			}
		}
		return tree;
	}

	/**
	 * 递归查找子菜单
	 *
	 * @param menus  Menu集合对象
	 * @param parent 父级菜单
	 * @return 带有子菜单的父级菜单
	 */
	public static Menu findChildren(List<Menu> menus, Menu parent) {
		for (Menu child : menus) {
			if (child.getPid().equals(parent.getId())) {
				parent.getChild().add(findChildren(menus, child));
			}
		}
		return parent;
	}
}
