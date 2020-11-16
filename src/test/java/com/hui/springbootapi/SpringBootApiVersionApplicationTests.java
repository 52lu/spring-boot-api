package com.hui.springbootapi;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class SpringBootApiVersionApplicationTests {

    @Test
    void contextLoads() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("msg","手机号格式不正确");
        stringObjectHashMap.put("code",400);
        String s = JSONUtil.parse(stringObjectHashMap).toString();
        String s1 = JSONUtil.toJsonStr(stringObjectHashMap);
        System.out.println(s);
        System.out.println(s1);
    }

}
