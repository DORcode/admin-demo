package com.coin.base.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("请求响应结果")
@Data
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "是否成功")
    private boolean success;
    @ApiModelProperty(value = "编码")
    private Integer code;
    @ApiModelProperty(value = "描述")
    private String msg;
    @ApiModelProperty(value = "数据")
    private T data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public Result(boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(ResultCodeEnum code) {
        return new Result(true, code.getCode(), code.getMsg());
    }

    public static Result fail(ResultCodeEnum code) {
        return new Result(false, code.getCode(), code.getMsg());
    }

    public static Result fail(ResultCodeEnum code, String str) {
        return new Result(false, code.getCode(), code.getMsg() + ":" + str);
    }

    public static Result success() {
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }


    public static Result success(Object data) {
        return new Result(true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    public static Result success(ResultCodeEnum code, Object data) {
        return new Result(true, code.getCode(), code.getMsg(), data);
    }

    public static Result fail(BaseException be) {
        if (be.getCode() == null) {
            return new Result(false, 3001, be.getMsg());
        }

        return new Result(false, be.getCode(), be.getMsg());
    }

    public static Result rows(long total, List<?> data) {
        return success(new PageInfo(total, data));
    }

    public static Result rows(long total, long current, int size, List<?> data) {
        return success(new PageInfo(total, current, size, data));
    }

}
