package com.asd.backened.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.asd.backened.dto.DishDto;
import com.asd.backened.entity.Dish;

public interface DishService extends IService<Dish> {

    //Add dishes and insert the corresponding taste data of dishes at the same time. Two tables need to be operated: DISH and DISH_flavor
    public void saveWithFlavor(DishDto dishDto);

    //Query the dish information and the corresponding flavor information according to the ID
    public DishDto getByIdWithFlavor(Long id);

    //Update the information of dishes and the corresponding flavor information
    public void updateWithFlavor(DishDto dishDto);
}
