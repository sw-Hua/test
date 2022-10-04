/**
 * Copyright (C), 2015-2022, XXX有限公司
 * FileName: testDish
 * Author:   benjamen
 * Date:     2022/10/3 18:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.asd.backened;

import com.asd.backened.controller.DishController;
import com.asd.backened.dto.DishDto;
import com.asd.backened.entity.Dish;
import com.asd.backened.mapper.DishMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * <br>
 * 〈〉
 *
 * @author Yongyan Liu
 * @create 2022/10/1
 * @since 1.0.0
 */

@SpringBootTest
@Transactional
@Rollback(value = true)
public class testDish {
    @Autowired
    private DishController dishController;

    @BeforeEach
    void setUp() {
        System.out.println("Starting Dish service test");
    }

    @Test
    void testpage() {
        dishController.page(4,3,"cocola");

    }
    @Test
    void testgetById() {
        long l = new Random().nextLong();

        dishMapper.deleteById(l);

    }
    @Test
    void testsave() {
        DishDto dish = new DishDto();
        long l = new Random().nextLong();
        dish.setName("test");
        dish.setCreateTime(LocalDateTime.now());
        dish.setUpdateTime(LocalDateTime.now());
        dish.setCreateUser(l);
        dish.setUpdateUser(l);
        dishMapper.updateById(dish);

    }
    @Autowired
    private DishMapper dishMapper;
    @Test
    void testdelete() {
        Dish dish = new Dish();
        long l = new Random().nextLong();
        dish.setName("test");
        dish.setCreateTime(LocalDateTime.now());
        dish.setUpdateTime(LocalDateTime.now());
        dish.setCreateUser(l);
        dish.setUpdateUser(l);
        dishMapper.deleteById(l);

    }
    @Test
    void testselectById() {
        Dish dish = new Dish();
        long l = new Random().nextLong();
        dish.setName("test");
        dish.setCreateTime(LocalDateTime.now());
        dish.setUpdateTime(LocalDateTime.now());
        dish.setCreateUser(l);
        dish.setUpdateUser(l);
        dishMapper.selectById(l);

    }
    

}
