package com.asd.backened.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**   Yongyan Liu
 * setmeal
 */
@Data
@ApiModel("setmeal")
public class Setmeal implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;


    //class id
    @ApiModelProperty("sort id")
    private Long categoryId;


    //Package name
    @ApiModelProperty("Package name")
    private String name;


    //price
    @ApiModelProperty("price")
    private BigDecimal price;


    //Status 0: disabled 1: enabled
    @ApiModelProperty("Status")
    private Integer status;


    //code
    @ApiModelProperty("Package number")
    private String code;


    //description
    @ApiModelProperty("description")
    private String description;


    //image
    @ApiModelProperty("image")
    private String image;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    @TableField(fill = FieldFill.INSERT)
    private Long createUser;


    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;

}
