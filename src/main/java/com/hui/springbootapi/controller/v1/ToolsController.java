package com.hui.springbootapi.controller.v1;

import cn.hutool.captcha.ShearCaptcha;
import com.hui.springbootapi.annotion.NoVerifyLogin;
import com.hui.springbootapi.service.AssistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;

@RestController("ToolsController-v1")
@RequestMapping("v1/tools")
@Api(tags = "工具列表")
@Slf4j
@Validated
public class ToolsController {
    @Resource
    private AssistService tokenService;

    @ApiOperation("获取图形验证码")
    @GetMapping("getImgCode")
    @NoVerifyLogin
    public void getImgCode(@NotBlank(message = "mac地址不能为空") @RequestParam("mac") String mac,HttpServletResponse httpServletResponse
    ) throws IOException {
        ShearCaptcha shearCaptcha = tokenService.generateImgCode(mac);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        shearCaptcha.write(outputStream);
        outputStream.close();
    }
}
