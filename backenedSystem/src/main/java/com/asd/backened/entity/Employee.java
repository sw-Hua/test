package com.asd.backened.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Employee entity
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String name;

    private String password;

    private String phone;

    private String sex;

    private String idNumber;//ID

    private Integer status;

    @TableField(fill = FieldFill.INSERT) //Fields are populated when inserted
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //Populate fields when inserting and updating
    private LocalDateTime updateTime;

    @TableField(fill = FieldFill.INSERT) //Fields are populated when inserted
    private Long createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE) //Populate fields when inserting and updating
    private Long updateUser;

}
