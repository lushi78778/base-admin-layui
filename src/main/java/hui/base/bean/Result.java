package hui.base.bean;

/**
 * 统一返回值类型
 *
 * @author hui
 * @date 2021-06-24 23:29:29
 */
public class Result {
	/**
	 * 返回码
	 */
	private Integer code;
	/**
	 * 返回消息
	 */
	private String msg;
	/**
	 * 数据对象
	 */
	private Object data;

	public Result(RetCode retCode) {
		this.code = retCode.getCode();
		this.msg = retCode.getMsg();
	}

	public Result(RetCode retCode, Object data) {
		this.code = retCode.getCode();
		this.msg = retCode.getMsg();
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}