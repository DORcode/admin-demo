package com.coin.auth.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Result
 * @Description: 请求返回结果
 * @Author kh
 * @Date 2020/1/16 17:41
 * @Version V1.0
 **/
@Data
public class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result response(ResultCodeEnum code) {
        return new Result(code.getCode(), code.getMsg());
    }

    public static Result success() {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }


    public static Result success(Object data) {
        return new Result(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    public static Result success(ResultCodeEnum code, Object data) {
        return new Result(code.getCode(), code.getMsg(), data);
    }

    public static Result fail(BaseException be) {
        if(be.getCode() == null) {
            return new Result(3001, be.getMsg());
        }

        return new Result(be.getCode(), be.getMsg());

    }

    public static Result rows(long total, List<?> data) {
        return success(new PageInfo(total, data));
    }

    public static Result rows(long total, long current, int size, List<?> data) {
        return success(new PageInfo(total, current, size, data));
    }

}
