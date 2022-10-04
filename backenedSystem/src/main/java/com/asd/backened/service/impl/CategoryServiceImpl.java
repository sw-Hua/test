package com.asd.backened.service.impl;

import com.asd.backened.mapper.CategoryMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.asd.backened.entity.Category;
import com.asd.backened.entity.Dish;
import com.asd.backened.entity.Setmeal;
import com.asd.backened.service.CategoryService;
import com.asd.backened.service.DishService;
import com.asd.backened.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService{

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * Need to check whether a category is deleted based on its ID
     * @param id
     */
    @Override
    public void remove(Long id) {

        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //Add the search criteria to query the information by category ID
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        log.info(count1+" items");
        //Queries whether the current category is associated with dishes. If yes, a service exception is thrown
//        if(count1 > 0){
//            //A service exception is thrown when a dish has been associated
//            throw new CustomException("The current category is associated with dishes, can not be deleted");
//        }

        //Query whether the current category is associated with a package. If yes, throw a service exception
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //Add the search criteria to query the information by category ID
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count();
//        log.info(count2.toString());
//        if(count2 > 0){
//            //The package has been associated and a business exception is thrown
//            throw new CustomException("The current category is associated with packages and cannot be deleted");
//        }

        //Deleting a Category
        super.removeById(id);
    }
}
