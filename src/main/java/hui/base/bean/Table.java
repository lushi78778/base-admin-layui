package hui.base.bean;

/**
 * 表格接口返回值类型
 *
 * @author hui
 * @date 2021-07-29 15:54:28
 */
public class Table extends Result {
	/**
	 * 总行数
	 */
	private Integer count;

	public Table(RetCode retCode, Object data, Integer count) {
		super(retCode, data);
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
