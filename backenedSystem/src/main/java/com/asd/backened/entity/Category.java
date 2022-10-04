package com.asd.backened.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**  Yongyan Liu
 * classify
 */
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    //Type 1 Dish classification 2 package classification
    private Integer type;


    //Class name
    private String name;


    //sort
    private Integer sort;


    //create time
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    //update time
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    //create user
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;


    //update user
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
