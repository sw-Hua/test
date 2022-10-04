package com.asd.backened.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * userinfo
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;


    //name
    private String name;


    //phone
    private String phone;


    //Gender 0 female 1 male
    private String sex;


    //ID number
    private String idNumber;


    //head portrait
    private String avatar;


    //Status 0: disabled, 1: Normal
    private Integer status;
}
