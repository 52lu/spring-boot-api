package com.hui.springbootapi.dto.req;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.hui.springbootapi.annotion.CheckPhone;
import com.hui.springbootapi.model.entity.UserEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterParam {
    @ApiModelProperty("手机号")
    @CheckPhone
    private String phone;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty("手机验证码")
    @NotBlank(message = "手机验证码不能为空")
    private String captCode;

    @ApiModelProperty("图形验证码")
    @NotBlank(message = "图形验证码不能为空")
    private String imgCode;

    @ApiModelProperty("mac地址")
    @NotBlank(message = "mac地址不能为空")
    private String mac;

    public  UserEntity transform2UserEntity( ){
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone(this.getPhone());
        userEntity.setPassword(this.getPassword());
        String now = DateUtil.now();
        DateTime nowDate = DateUtil.parse(now, "yyyy-MM-dd HH:mm:ss");
        userEntity.setCreateTime(nowDate);
        return  userEntity;
    }
}
