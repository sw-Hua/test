package com.asd.backened.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.asd.backened.common.R;
import com.asd.backened.entity.Employee;
import com.asd.backened.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Staff login
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request,@RequestBody Employee employee){

        //1、The password that the page submits is encrypted by MD5
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2、Query the database based on the username submitted by the page
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //3、If no, the login failure result is displayed
        if(emp == null){
            return R.error("login failure");
        }

        //4、If the passwords are inconsistent, the login failure result is displayed
        if(!emp.getPassword().equals(password)){
            return R.error("login failure");
        }

        //5、Check the employee status. If the employee status is disabled, the result that the employee is disabled is returned
        if(emp.getStatus() == 0){
            return R.error("账号已禁用");
        }

        //6、If the login succeeds, the employee ID is saved into Session and the login success result is returned
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * Employees quit
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        //Clear the ID of the current login employee saved in the Session
        request.getSession().removeAttribute("employee");
        return R.success("Exit the success");
    }

    /**
     * The new employee
     * @param employee
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        log.info("New employees, employee information:{}",employee.toString());

        //The initial password is 123456. Md5 encryption is required
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        //employee.setCreateTime(LocalDateTime.now());
        //employee.setUpdateTime(LocalDateTime.now());

        //Gets the ID of the currently logged in user
        //Long empId = (Long) request.getSession().getAttribute("employee");

        //employee.setCreateUser(empId);
        //employee.setUpdateUser(empId);

        employeeService.save(employee);

        return R.success("Successful addition of new employees");
    }

    /**
     * Paging query of employee information
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        log.info("page = {},pageSize = {},name = {}" ,page,pageSize,name);

        //Construct the page constructor
        Page pageInfo = new Page(page,pageSize);

        //Construct the conditional constructor
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        //Adding Filter Criteria
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        //Add sort criteria
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        //execution query
        employeeService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * Modify employee information based on ID
     * @param employee
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        log.info(employee.toString());

        long id = Thread.currentThread().getId();
        log.info("The thread ID is:{}",id);
        //Long empId = (Long)request.getSession().getAttribute("employee");
        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(empId);
        employeeService.updateById(employee);

        return R.success("The employee information is modified successfully. ");
    }

    /**
     * Query employee information by ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        log.info("Query employee information by ID...");
        Employee employee = employeeService.getById(id);
        if(employee != null){
            return R.success(employee);
        }
        return R.error("The corresponding employee information is not found");
    }
}
