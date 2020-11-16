package com.hui.springbootapi.aspect;

import cn.hutool.core.util.StrUtil;
import com.hui.springbootapi.annotion.NoVerifyLogin;
import com.hui.springbootapi.dto.ResponseResult;
import com.hui.springbootapi.enums.ResponseCodeEnum;
import com.hui.springbootapi.exception.ApiException;
import com.hui.springbootapi.service.AssistService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class CheckLoginAspect {
    @Resource
    private AssistService assistService;
    @Resource
    HttpServletRequest httpServletRequest;

    @Pointcut("execution(* com.hui.springbootapi.controller.*.*.*(..))")
    void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("proceedingJoinPoint = " + args);
        if (verifyToken(proceedingJoinPoint)){
            return proceedingJoinPoint.proceed();
        } else {
            return ResponseResult.error(ResponseCodeEnum.TOKEN_TIMEOUT);
        }
    }

    /**
     * 校验token信息
     * @param proceedingJoinPoint
     * @return
     */
    public Boolean verifyToken(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        // 过滤不需要验证登录的接口
        if (signature.getMethod().isAnnotationPresent(NoVerifyLogin.class)) {
            return true;
        }
        // 从HEADER获取参数信息
        String uid = httpServletRequest.getHeader("UID");
        String token = httpServletRequest.getHeader("TOKEN");
        if (StrUtil.isEmpty(uid) || StrUtil.isEmpty(token)){
            throw new ApiException(ResponseCodeEnum.TOKEN_PARAM_LOST);
        }
        // 校验token
        return assistService.verifyToken(uid,token);
    }
}
