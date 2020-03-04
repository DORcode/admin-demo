package com.coin.auth.util;

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
    LOGIN_SUCCESS(2001, "登录成功"),
    LOGINED(2002, "已登录！"),

    LOGINOUT_SUCCESS(2010, "登出成功"),
    ACCOUNT_ERROR(3001, "帐户或密码错误！"),
    PARAM_ERROR(1001, "参数错误"),
    SERVER_ERROR(5001, "服务端异常！");
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
