package comg.yang.alibabacommon.entity;

import lombok.Data;

@Data
public class Result<T> {

    private T data;

    private int code;

    private boolean status;

    private String message;


    public Result(T data, boolean status, int code, String message) {
        this.data = data;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T t) {
        return new Result<T>(t, true, 200, null);
    }

}
