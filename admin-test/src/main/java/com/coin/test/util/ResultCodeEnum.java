package com.coin.test.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ResultCodeEnum
 * @Description: TODO
 * @Author kh
 * @Date 2020/1/16 17:49
 * @Version V1.0
 **/

public enum ResultCodeEnum {
    SUCCESS(200, "请求成功"),
    PARAM_ERROR(1001, "参数错误");
    @Getter
    @Setter
    private Integer code;
    @Getter
    @Setter
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
