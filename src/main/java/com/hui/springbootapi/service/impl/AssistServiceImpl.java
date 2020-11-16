package com.hui.springbootapi.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.hui.springbootapi.enums.ResponseCodeEnum;
import com.hui.springbootapi.exception.ApiException;
import com.hui.springbootapi.service.AssistService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class AssistServiceImpl implements AssistService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public String generateToken(int uid) {
        String confuseStr = "@38&97!2-+^&@9#JKHK@0903$S2UIU3";
        String sign = confuseStr + uid + System.currentTimeMillis();
        String token = SecureUtil.md5(sign);
        stringRedisTemplate.opsForValue().set("User:Token:"+uid,token, 30, TimeUnit.DAYS);
        return token;
    }
    @Override
    public Boolean verifyToken(String uid, String token) {
        String cacheToken = stringRedisTemplate.opsForValue().get("User:Token:" + uid);
        return token.equals(cacheToken);
    }

    @Override
    public ShearCaptcha generateImgCode(String mac) {
        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        String code = shearCaptcha.getCode();
        stringRedisTemplate.opsForValue().set("ImgCode:"+mac,code,5,TimeUnit.MINUTES);
        return shearCaptcha;
    }

    @Override
    public Boolean verifyImgCode(String mac, String imgCode) {
        String cacheImgCode = stringRedisTemplate.opsForValue().get("ImgCode:" + mac);
        if (StrUtil.isEmpty(cacheImgCode)){
            throw new ApiException(ResponseCodeEnum.IMG_CODE_TIME_OUT);
        }
        return cacheImgCode.equals(imgCode);
    }
}
