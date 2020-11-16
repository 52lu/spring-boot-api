/**
 * @author : Mr.Liuqh
 * @date : 2020-11-13 15:16:33
 */
package com.hui.springbootapi.model.entity;

import java.io.Serializable;
import java.util.Date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.hui.springbootapi.dto.req.UserRegisterParam;
import lombok.Data;

/**
 *
 * 用户基础表
 *
 * 表名: micro_user
 */
@Data
public class UserEntity implements Serializable {
    /**
     *
     * 备注:用户id
     *
     * 表字段: micro_user.id
     */
    private Integer id;

    /**
     *
     * 备注:昵称
     *
     * 表字段: micro_user.nick_name
     */
    private String nickName;

    /**
     *
     * 备注:密码:md5
     *
     * 表字段: micro_user.password
     */
    private String password;

    /**
     *
     * 备注:手机号
     *
     * 表字段: micro_user.phone
     */
    private String phone;

    /**
     *
     * 备注:最后一次登录时间
     *
     * 表字段: micro_user.last_login_time
     */
    private Date lastLoginTime;

    /**
     *
     * 备注:0:未激活 1:正常 2:禁用
     *
     * 表字段: micro_user.status
     */
    private Byte status;

    /**
     *
     * 备注:创建时间
     *
     * 表字段: micro_user.create_time
     */
    private Date createTime;

    /**
     *
     * 备注:更新时间
     *
     * 表字段: micro_user.update_time
     */
    private Date updateTime;

    /**
     *
     * 备注:1:删除 0:未删除
     *
     * 表字段: micro_user.is_delete
     */
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public UserEntity(Integer id, String nickName, String password, String phone, Date lastLoginTime, Byte status, Date createTime, Date updateTime, Byte isDelete) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.lastLoginTime = lastLoginTime;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public UserEntity() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickName=").append(nickName);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}