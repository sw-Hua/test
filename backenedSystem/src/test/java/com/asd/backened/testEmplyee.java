/**
 * Copyright (C), 2015-2022, XXX有限公司
 * FileName: testEmplyee
 * Author:   benjamen
 * Date:     2022/10/3 17:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.asd.backened;

import com.asd.backened.controller.EmployeeController;
import com.asd.backened.entity.Category;
import com.asd.backened.entity.Employee;
import com.asd.backened.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
public class testEmplyee {

    @Autowired
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        System.out.println("Starting empolyee service test");
    }

    @Test
    void testpage() {
        employeeController.page(5,3,"admin");

    }
    @Test
    void testgetById() {
        long l = new Random().nextLong();

        employeeController.getById(l);

    }
    @Test
    void testsave() {
        Employee employee = new Employee();
        long l = new Random().nextLong();
        employee.setName("test");
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateUser(l);
        employee.setUpdateUser(l);
        employeeController.getById(l);

    }
@Autowired
public EmployeeService  employeeService;
    @Test
    void testlist() {
        Employee employee = new Employee();
        long l = new Random().nextLong();
        employee.setName("test");
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateUser(l);
        employee.setUpdateUser(l);

        employeeService.list();
    }
    @Test
    void testLogin() {
        Employee employee = new Employee();
        long l = new Random().nextLong();
        employee.setName("test");
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateUser(l);
        employee.setUpdateUser(l);

        employeeService.count();
    }
}
