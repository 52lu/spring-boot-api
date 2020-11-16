package com.hui.springbootapi.service;

import com.hui.springbootapi.dto.req.UserRegisterParam;
import com.hui.springbootapi.dto.res.UserResponse;
import com.hui.springbootapi.model.entity.UserEntity;

public interface UserService {

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    UserEntity searchUserByPhone(String phone);

    /**
     * 密码登录
     * @param phone
     * @param pwd
     * @return
     */
    UserResponse passwordLogin(String phone, String pwd);

    /**
     * 注册
     * @return
     */
    UserResponse register(UserRegisterParam userRegisterParam);
}
