package com.coin.base.config;

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

    LOGIN_SUCCESS(200, "登录成功"),
    LOGINED(200, "已登录！"),

    LOGINOUT_SUCCESS(200, "登出成功"),
    UNLOGIN(401, "未登录"),
    TOKEN_EXPIRE(401, "token过期"),

    LOGON_SUCCESS(200, "注册成功"),
    LOGON_FAIL(2031, "注册失败"),

    CHG_PWD_SUCCESS(200, "修改密码成功"),

    VERIFY_CODE_G_ERROR(2033, "生成验证码异常，请重试"),
    VERIFY_CODE_SUCCESS(200, "输入验证码正确"),
    VERIFY_CODE_FAIL(2035, "输入验证码错误"),
    VERIFY_CODE_NULL(2036, "验证码不应该为空"),

    VERIFY_CODE_EXCEPT(2037, "验证码异常，请重新选择并输入"),
    VERIFY_CODE_EXPIRE(2038, "验证码已过期，请重新选择并输入"),

    USERNAME_EXISTS(2039, "用户名已存在"),
    USERNAME_UNIQUE(2040, "用户名可用"),

    PHONE_EXISTS(2041, "手机号已存在"),
    PHONE_UNIQUE(2042, "手机号可用"),

    PARAM_IS_NULL(2050, "参数不应该为空"),
    SECRET_IS_NULL(2051, "密码不应该为空"),

    ROLE_NOT_EXISTD(2052, "角色不存在"),

    SAVE_FAIL(2060, "保存失败"),
    SAVE_SUCCESS(200, "保存成功"),

    DELETE_FAIL(2070, "删除失败"),
    DELETE_SUCCESS(200, "删除成功"),

    UPDATE_FAIL(2080, "更新失败"),
    UPDATE_SUCCESS(200, "更新成功"),

    SEND_SUCCESS(2092, "发送消息成功"),
    REPLY_SUCCESS(200, "回复消息成功"),

    UNUNIQUE(2100, "数据库已存在，不唯一"),

    USER_NOT_EXIST(2101, "用户不存在"),
    OLD_PASSWORD_ERROR(2102, "原密码输入不正确"),

    DATA_NOT_EXISTS(2103, "数据不存在"),


    AVATAR_PROC_FAIL(2104, "图像处理失败"),

    AVATAR_TYPE_ERROR(2105, "文件要求是jpg或png格式"),
    EXPORT_SUCCESS(200, "导出成功"),
    EXPORT_FAIL(2107, "导出失败"),
    EXPORT_FAIL_NODATA(2108, "未查询到上报数据"),

    IMAGE_TOO_LARGE(2109, "图像超过50KB，请调整大小后上传"),

    ACCOUNT_ERROR(3001, "帐户或密码错误！"),
    ACCOUNT_FORBIDDEN(3002, "帐户被禁用！"),
    PARAM_ERROR(4001, "参数错误"),
    LIST_EMPTY_ERROR(4002, "列表不应该为！"),
    SERVER_ERROR(5001, "服务端异常！"),

    DEMANDINFO_UPDATE_FAIL(7001, "发文信息错误,更新失败"),
    DEMANDINFO_LIST_FAIL(7002, "分页查询发文参数错误,查询失败");

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
