package com.hui.springbootapi;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.hui.springbootapi.model.dao.UserDao;
import com.hui.springbootapi.model.entity.UserEntity;
import com.hui.springbootapi.model.entity.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MybatisQueryTests {
    @Resource
    private UserDao userDao;
    @Test
    void query() {
        UserQuery userQuery = new UserQuery();
        userQuery.createCriteria().andPhoneEqualTo("17600113418");
        List<UserEntity> userEntities = userDao.selectByExample(userQuery);
        String s = JSONUtil.toJsonStr(userEntities);
        System.out.println(1);
    }
}
