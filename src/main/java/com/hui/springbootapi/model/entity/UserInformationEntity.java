/**
        * @author : Mr.Liuqh
        * @date : 2020-11-13 15:16:33
        */
package com.hui.springbootapi.model.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
                    *
                * 用户扩展信息表
        *
        * 表名: micro_user_information
        */
@Data
public class UserInformationEntity implements Serializable {
    /**
                *
                *
                * 表字段: micro_user_information.id
                */
    private Integer id;

    /**
                *
                        * 备注:用户id
                *
                * 表字段: micro_user_information.uid
                */
    private Integer uid;

    /**
                *
                        * 备注:手机号
                *
                * 表字段: micro_user_information.phone
                */
    private String phone;

    /**
                *
                        * 备注:姓名
                *
                * 表字段: micro_user_information.name
                */
    private String name;

    /**
                *
                        * 备注:年龄
                *
                * 表字段: micro_user_information.age
                */
    private Byte age;

    /**
                *
                        * 备注:生日
                *
                * 表字段: micro_user_information.birthday
                */
    private Date birthday;

    /**
                *
                        * 备注:身份证号码
                *
                * 表字段: micro_user_information.id_card
                */
    private String idCard;

    /**
                *
                        * 备注:家庭住址
                *
                * 表字段: micro_user_information.address
                */
    private String address;

    /**
                *
                        * 备注:创建时间
                *
                * 表字段: micro_user_information.create_time
                */
    private Date createTime;

    /**
                *
                        * 备注:更新时间
                *
                * 表字段: micro_user_information.update_time
                */
    private Date updateTime;

    /**
                *
                        * 备注:1:删除 0:未删除
                *
                * 表字段: micro_user_information.is_delete
                */
    private Byte isDelete;

    private static final long serialVersionUID = 1L;

    public UserInformationEntity(Integer id, Integer uid, String phone, String name, Byte age, Date birthday, String idCard, String address, Date createTime, Date updateTime, Byte isDelete) {
        this.id = id;
        this.uid = uid;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.idCard = idCard;
        this.address = address;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public UserInformationEntity() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", phone=").append(phone);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", idCard=").append(idCard);
        sb.append(", address=").append(address);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}