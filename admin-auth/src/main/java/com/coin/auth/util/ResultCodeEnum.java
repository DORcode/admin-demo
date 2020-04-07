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
    TOKEN_EXPIRE(2020, "token过期"),

    LOGON_SUCCESS(2030, "注册成功"),
    LOGON_FAIL(2031, "注册失败"),

    UNLOGIN(2040, "未登录"),

    PARAM_IS_NULL(2050, "参数不应该为空"),

    SAVE_FAIL(2060, "保存失败"),
    SAVE_SUCCESS(2061, "保存成功"),

    DELETE_FAIL(2070, "删除失败"),
    DELETE_SUCCESS(2070, "删除成功"),

    UPDATE_FAIL(2080, "更新失败"),
    UPDATE_SUCCESS(2091, "更新成功"),

    ACCOUNT_ERROR(3001, "帐户或密码错误！"),
    PARAM_ERROR(4001, "参数错误"),
    LIST_EMPTY_ERROR(4002, "列表不应该为！"),
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
