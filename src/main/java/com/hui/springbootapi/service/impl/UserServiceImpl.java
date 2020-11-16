package com.hui.springbootapi.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.hui.springbootapi.dto.req.UserRegisterParam;
import com.hui.springbootapi.enums.ResponseCodeEnum;
import com.hui.springbootapi.exception.ApiException;
import com.hui.springbootapi.model.dao.UserDao;
import com.hui.springbootapi.dto.res.UserResponse;
import com.hui.springbootapi.model.entity.UserEntity;
import com.hui.springbootapi.model.entity.UserQuery;
import com.hui.springbootapi.service.AssistService;
import com.hui.springbootapi.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户管理
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private AssistService assistService;

    @Override
    @Cacheable(cacheNames = "user:service",key = "'phone:'+#phone",unless = "#result == null ")
    public UserEntity searchUserByPhone(String phone) {
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andPhoneEqualTo(phone);
        List<UserEntity> userEntities = userDao.selectByExample(userQuery);
        if (CollUtil.isNotEmpty(userEntities)){
            return userEntities.get(0);
        }
        return null;
    }

    @Override
    public UserResponse passwordLogin(String phone, String pwd) {
        // 查找手机号是否存在
        UserEntity userEntity = searchUserByPhone(phone);
        if (userEntity == null){
            throw new ApiException(ResponseCodeEnum.USER_PHONE_NOT_EXIST);
        }
        if (!userEntity.getPassword().equals(pwd)){
            throw new ApiException(ResponseCodeEnum.USER_LOGIN_PASSWORD_ERROR);
        }
        // 设置TOKEN信息
        String token = assistService.generateToken(userEntity.getId());
        UserResponse userResponse = UserResponse.userEntity2UserResponse(userEntity);
        userResponse.setToken(token);
        return userResponse;
    }

    @Override
    public UserResponse register(UserRegisterParam userRegisterParam) {
        UserEntity userEntity = searchUserByPhone(userRegisterParam.getPhone());
        if (userEntity != null){
            throw new ApiException(ResponseCodeEnum.USER_PHONE_EXIST);
        }
        // 校验图形验证码
        if (!assistService.verifyImgCode(userRegisterParam.getMac(),userRegisterParam.getImgCode())) {
            throw new ApiException(ResponseCodeEnum.IMG_CODE_ERROR);
        }
        // todo 手机验证码

        UserEntity newUserEntity = userRegisterParam.transform2UserEntity();
        userDao.insertSelective(newUserEntity);
        // 设置TOKEN信息
        String token = assistService.generateToken(newUserEntity.getId());
        UserResponse userResponse = UserResponse.userEntity2UserResponse(newUserEntity);
        userResponse.setToken(token);
        return userResponse;
    }
}
