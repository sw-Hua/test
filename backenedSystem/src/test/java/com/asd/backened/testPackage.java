/**
 * Copyright (C), 2015-2022, XXX有限公司
 * FileName: testPackage
 * Author:   benjamen
 * Date:     2022/10/3 18:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.asd.backened;


import com.asd.backened.controller.SetmealController;
import com.asd.backened.entity.Dish;
import com.asd.backened.entity.Setmeal;
import com.asd.backened.mapper.SetmealMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.Random;
import java.time.LocalDateTime;

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
public class testPackage {
    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private SetmealController setmealController;


    @BeforeEach
    void setUp() {
        System.out.println("Starting Dish service test");
    }

    @Test
    void testpage() {
        setmealController.page(4,3,"cocola");

    }
    @Test
    void testgetById() {


        long l = new Random().nextLong();

        setmealMapper.deleteById(l);

    }
    @Test
    void testsave() {
        Setmeal setmeal = new Setmeal();
        long l = new Random().nextLong();
        setmeal.setName("test");
        setmeal.setCreateTime(LocalDateTime.now());
        setmeal.setUpdateTime(LocalDateTime.now());
        setmeal.setCreateUser(l);
        setmeal.setUpdateUser(l);
        setmealMapper.updateById(setmeal);

    }

    @Test
    void testdelete() {
        Dish dish = new Dish();
        long l = new Random().nextLong();
        dish.setName("test");
        dish.setCreateTime(LocalDateTime.now());
        dish.setUpdateTime(LocalDateTime.now());
        dish.setCreateUser(l);
        dish.setUpdateUser(l);
        setmealMapper.deleteById(l);

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
        setmealMapper.selectById(l);

    }


}
