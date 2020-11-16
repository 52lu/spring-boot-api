/**
        * @author : Mr.Liuqh
        * @date : 2020-11-13 15:16:33
        */
package com.hui.springbootapi.model.dao;

import com.hui.springbootapi.model.entity.UserEntity;
import com.hui.springbootapi.model.entity.UserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    long countByExample(UserQuery example);

    int deleteByExample(UserQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserQuery example);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserQuery example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserQuery example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}