package com.hui.springbootapi;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HuToolTests {
    @Test
    void testDatetime() {
        String today = DateUtil.today();
        String now = DateUtil.now();
        DateTime nowDate = DateUtil.parse(now, "yyyy-MM-dd HH:mm:ss");
        System.out.println(today);
        System.out.println(now);
        System.out.println(nowDate);

    }

    @Test
    void testSign() {
        String s = "sjkshdkhsjkhsd";
        String s1 = SecureUtil.md5(s);
        String s2 = SecureUtil.sha1(s);

        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
        System.out.println(s2.length());
    }
}
