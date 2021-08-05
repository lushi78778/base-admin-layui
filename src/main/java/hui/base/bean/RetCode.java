package hui.base.bean;

/**
 * 统一返回值枚举常量
 *
 * @author hui
 * @date 2021-07-28 10:49:09
 */
public enum RetCode {
	/**
	 * 用户不存在
	 */
	LOGIN_SUCCESS(1000, "登录成功"),
	/**
	 * 用户不存在
	 */
	USER_NOT_EXIST(1001, "用户不存在"),
	/**
	 * 密码错误
	 */
	PASSWORD_ERROR(1002, "密码错误"),
	/**
	 * 验证码错误
	 */
	CAPTCHA_ERROR(1003, "验证码错误"),
	/**
	 * 接口调用成功
	 */
	OK(10000, "成功"),
	TABLE_OK(0, "数据表格接口调用成功");


	/**
	 * 返回码
	 */
	private final Integer code;
	/**
	 * 返回消息
	 */
	private final String msg;

	RetCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
