/**
 * Copyright (C), 2015-2022, XXX有限公司
 * FileName: testemplyee
 * Author:   benjamen
 * Date:     2022/10/3 17:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.asd.backened;

import com.asd.backened.controller.CategoryController;
import com.asd.backened.entity.Category;
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
 * @author Xuhao Guo
 * @create 2022/10/3
 * @since 1.0.0
 */


@SpringBootTest
@Transactional
@Rollback(value = true)
public class testCategory {


    @Autowired
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        System.out.println("Starting category service test");
    }

    @Test
    void testpage() {
        categoryController.page(4,3);

    }
    @Test
    void testremove() {
        long l = new Random().nextLong();

        categoryController.delete(l);

    }
    @Test
    void testsave() {
        Category category = new Category();
        long l = new Random().nextLong();
        category.setName("test");
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(l);
        category.setUpdateUser(l);
        categoryController.save(category);

    }
    @Test
    void testupdate() {
        Category category = new Category();
        long l = new Random().nextLong();
        category.setName("test");
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(l);
        category.setUpdateUser(l);
        categoryController.update(category);

    }
    @Test
    void testList() {
        Category category = new Category();
        long l = new Random().nextLong();
        category.setName("test");
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(l);
        category.setUpdateUser(l);
        categoryController.list(category);

    }
}
