package com.asd.backened.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.asd.backened.dto.DishDto;
import com.asd.backened.entity.Dish;
import com.asd.backened.entity.DishFlavor;
import com.asd.backened.mapper.DishMapper;
import com.asd.backened.service.DishFlavorService;
import com.asd.backened.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper,Dish> implements DishService {

    @Autowired
    private DishFlavorService dishFlavorService;

    /**
     * Add dishes and save the corresponding taste data
     * @param dishDto
     */
    @Transactional
    public void saveWithFlavor(DishDto dishDto) {
        //Save the basic information of a dish to the dish table dish
        this.save(dishDto);

        Long dishId = dishDto.getId();//Food id

        //Food tastes
        List<DishFlavor> flavors = dishDto.getFlavors();
        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());

        //Save the dish flavor data to the dish flavor table
        dishFlavorService.saveBatch(flavors);

    }

    /**
     * Query the dish information and the corresponding flavor information according to the ID
     * @param id
     * @return
     */
    public DishDto getByIdWithFlavor(Long id) {
        //Query the basic information of dishes from the dish table
        Dish dish = this.getById(id);

        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);

        //Query the flavor information of the current dish based on the DISH_FLAVOR table
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DishFlavor::getDishId,dish.getId());
        List<DishFlavor> flavors = dishFlavorService.list(queryWrapper);
        dishDto.setFlavors(flavors);

        return dishDto;
    }

    @Override
    @Transactional
    public void updateWithFlavor(DishDto dishDto) {
        //Update the DISH table information
        this.updateById(dishDto);

        //Delete the current dish's flavor data - DISH_FLAVOR table
        LambdaQueryWrapper<DishFlavor> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(DishFlavor::getDishId,dishDto.getId());

        dishFlavorService.remove(queryWrapper);

        //Add THE CURRENTLY SUBMITTED FLAVOR DATA - THE INSERT OPERATION IN THE DISH_FLAVOR TABLE
        List<DishFlavor> flavors = dishDto.getFlavors();

        flavors = flavors.stream().map((item) -> {
            item.setDishId(dishDto.getId());
            return item;
        }).collect(Collectors.toList());

        dishFlavorService.saveBatch(flavors);
    }
}
