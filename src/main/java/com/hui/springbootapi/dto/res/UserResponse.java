package com.hui.springbootapi.dto.res;

import com.hui.springbootapi.model.entity.UserEntity;
import lombok.Data;

@Data
public class UserResponse {
    private long uid;
    private String token;
    private String phone;
    private String nickName;

    /**
     * userEntity转UserResponse
     * @param userEntity
     * @return
     */
    public static UserResponse userEntity2UserResponse(UserEntity userEntity){
        UserResponse userResponse = new UserResponse();
        userResponse.setPhone(userEntity.getPhone());
        userResponse.setNickName(userEntity.getNickName());
        userResponse.setUid(userEntity.getId());
        return userResponse;
    }
}
