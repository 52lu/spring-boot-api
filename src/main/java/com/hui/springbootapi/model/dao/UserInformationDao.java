/**
        * @author : Mr.Liuqh
        * @date : 2020-11-13 15:16:33
        */
package com.hui.springbootapi.model.dao;

import com.hui.springbootapi.model.entity.UserInformationEntity;
import com.hui.springbootapi.model.entity.UserInformationQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInformationDao {
    long countByExample(UserInformationQuery example);

    int deleteByExample(UserInformationQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInformationEntity record);

    int insertSelective(UserInformationEntity record);

    List<UserInformationEntity> selectByExample(UserInformationQuery example);

    UserInformationEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInformationEntity record, @Param("example") UserInformationQuery example);

    int updateByExample(@Param("record") UserInformationEntity record, @Param("example") UserInformationQuery example);

    int updateByPrimaryKeySelective(UserInformationEntity record);

    int updateByPrimaryKey(UserInformationEntity record);
}