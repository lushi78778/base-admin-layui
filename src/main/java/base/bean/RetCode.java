package base.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一返回值枚举常量
 *
 * @author hui
 * @date 2021-07-28 10:49:09
 */
@Getter
@AllArgsConstructor
public enum RetCode {
    /**
     * 统一返回值枚举常量
     */
    USER_LIST_SUCCESS(1001, "用户列表"),
    USER_SAVE_SUCCESS(1002, "添加/修改用户"),
    USER_DELETE_SUCCESS(1003, "删除用户"),
    ROLE_LIST_SUCCESS(1001, "角色列表"),
    ROLE_SAVE_SUCCESS(1002, "添加/修改角色"),
    ROLE_DELETE_SUCCESS(1003, "删除角色"),
    MENU_LIST_SUCCESS(1001, "菜单列表"),
    MENU_SAVE_SUCCESS(1002, "添加/修改菜单"),
    MENU_DELETE_SUCCESS(1003, "删除菜单"),
    OK(10000, "成功");

    /**
     * 返回码
     */
    private final Integer code;
    /**
     * 返回消息
     */
    private final String msg;
}
