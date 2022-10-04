package com.asd.backened.dto;

import com.asd.backened.entity.Dish;
import com.asd.backened.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    //The corresponding taste data of the dishes
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
