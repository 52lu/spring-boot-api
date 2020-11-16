package com.hui.springbootapi.service;


import cn.hutool.captcha.ShearCaptcha;

/**
 * 辅助服务
 */
public interface AssistService {
    /**
     * 生成token
     * @param uid
     * @return
     */
    String generateToken(int uid);

    /**
     * 校验token
     * @param uid
     * @param token
     * @return
     */
    Boolean verifyToken(String uid,String token);


    /**
     * 生成图片验证码
     * @param mac
     * @return
     */
    ShearCaptcha generateImgCode(String mac);

    /**
     * 校验图片验证码
     * @param mac
     * @param imgCode
     * @return
     */
    Boolean verifyImgCode(String mac,String imgCode);

}
