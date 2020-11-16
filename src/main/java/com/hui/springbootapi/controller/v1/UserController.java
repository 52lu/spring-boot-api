package com.hui.springbootapi.controller.v1;

import com.hui.springbootapi.annotion.ApiVersion;
import com.hui.springbootapi.annotion.CheckPhone;
import com.hui.springbootapi.annotion.NoVerifyLogin;
import com.hui.springbootapi.dto.ResponseResult;
import com.hui.springbootapi.dto.req.UserRegisterParam;
import com.hui.springbootapi.dto.res.UserResponse;
import com.hui.springbootapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Api(tags = "用户管理")
@RestController("UserController-V1")
@ApiVersion
@RequestMapping(value = "v1/user")
@Validated
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 密码登录
     */
    @ApiOperation(value = "密码登录")
    @GetMapping("pwdLogin")
    @NoVerifyLogin
    public ResponseResult<UserResponse> pwdLogin(
            @CheckPhone @RequestParam("phone") String phone,
            @NotEmpty @RequestParam("pwd") String password
    ){
        UserResponse userResponse = userService.passwordLogin(phone, password);
        return ResponseResult.success(userResponse);
    }

    /**
     * 用户注册
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("register")
    @NoVerifyLogin
    public ResponseResult<UserResponse> register(@Valid UserRegisterParam userRegisterParam){
        UserResponse register = userService.register(userRegisterParam);
        return ResponseResult.success(register);
    }


}
