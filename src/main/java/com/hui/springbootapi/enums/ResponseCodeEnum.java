package com.hui.springbootapi.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应码枚举类
 */
@AllArgsConstructor
public enum ResponseCodeEnum {
    SUCCESS(200, "处理成功!"),
    ERROR(0, "处理失败!"),
    SYSTEM_ERROR(500, "服务响应失败!"),
    // 登录注册校验
    USER_PHONE_NOT_EXIST(11000, "用户不存在!"),
    USER_PHONE_EXIST(11001, "手机号已经存在!"),
    USER_LOGIN_PASSWORD_ERROR(11002, "手机或密码不正确!"),
    IMG_CODE_TIME_OUT(11003, "图形验证码失效,请重新获取!"),
    IMG_CODE_ERROR(11004, "图形验证码不一致!"),
    // token相关
    TOKEN_TIMEOUT(2000, "登录超时，请重新登录!"),
    TOKEN_PARAM_LOST(2001, "令牌参数丢失!");

    public int code;
    public String msg;
}
