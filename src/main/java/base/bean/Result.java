package base.bean;

import lombok.Data;

/**
 * 统一返回值类型
 *
 * @author hui
 * @date 2021-06-24 23:29:29
 */
@Data
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
    /**
     * 表格数据总条数
     */
    private Integer count;

    public Result(RetCode retCode) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
    }

    public Result(RetCode retCode, Object data) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
        this.data = data;
    }

    public Result(RetCode retCode, Object data, Integer count) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
        this.data = data;
        this.count = count;
    }
}