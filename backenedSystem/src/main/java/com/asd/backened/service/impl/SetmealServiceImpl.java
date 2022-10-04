package com.asd.backened.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.asd.backened.common.CustomException;
import com.asd.backened.dto.SetmealDto;
import com.asd.backened.entity.Setmeal;
import com.asd.backened.entity.SetmealDish;
import com.asd.backened.mapper.SetmealMapper;
import com.asd.backened.service.SetmealDishService;
import com.asd.backened.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper,Setmeal> implements SetmealService {

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * Add a set meal and save the association between the set meal and dishes
     * @param setmealDto
     */
    @Transactional
    public void saveWithDish(SetmealDto setmealDto) {
        //Save the basic information of the meal, perform the setMeal operation, and perform the INSERT operation
        this.save(setmealDto);

        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item) -> {
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        //Save the association information between the setmeal and dishes, run setmeal_dish, and perform the insert operation
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * To delete a set meal, delete the data associated with the set meal and dishes
     * @param ids
     */
    @Transactional
    public void removeWithDish(List<Long> ids) {
        //select count(*) from setmeal where id in (1,2,3) and status = 1
        //Query the package status to determine whether deletion is available
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);

        int count = this.count(queryWrapper);
        if(count > 0){
            //If not, throw a business exception
            throw new CustomException("The package is on sale and cannot be removed");
        }

        //If you can delete, delete the data in the meal list - setMeal
        this.removeByIds(ids);

        //delete from setmeal_dish where setmeal_id in (1,2,3)
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
        //Delete the data in the relational table ----setmeal Dish
        setmealDishService.remove(lambdaQueryWrapper);
    }
}
