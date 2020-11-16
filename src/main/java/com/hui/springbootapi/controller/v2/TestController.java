package com.hui.springbootapi.controller.v2;

import com.hui.springbootapi.annotion.ApiVersion;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("TestControllerV2")
@ApiVersion(2)
@RequestMapping("v2/test")
public class TestController {
    /**
     * 覆盖老版本的test/index方法
     */
    @ApiOperation(value = "v2测试接口",notes = "v2版本")
    @GetMapping("index")
    public String index(){
        return "v2 - index -> "+ System.currentTimeMillis();
    }
}
