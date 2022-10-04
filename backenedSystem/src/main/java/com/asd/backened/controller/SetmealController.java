package com.asd.backened.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.asd.backened.common.R;
import com.asd.backened.dto.SetmealDto;
import com.asd.backened.entity.Category;
import com.asd.backened.entity.Setmeal;
import com.asd.backened.service.CategoryService;
import com.asd.backened.service.SetmealDishService;
import com.asd.backened.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Yongyan Liu
 * Package management
 */

@RestController
@RequestMapping("/setmeal")
@Slf4j
@Api(tags = "Package-controller")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * The new package
     * @param setmealDto
     * @return
     */
    @PostMapping
    @CacheEvict(value = "setmealCache",allEntries = true)
    @ApiOperation(value = "New package interface")
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("Package Information:{}",setmealDto);

        setmealService.saveWithDish(setmealDto);

        return R.success("New package successfully added\n");
    }

    /**
     * Paging query of package
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "Package page query interface")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "page",required = true),
            @ApiImplicitParam(name = "pageSize",value = "Records per page",required = true),
            @ApiImplicitParam(name = "name",value = "Package name",required = false)
    })
    public R<Page> page(int page,int pageSize,String name){
        //Page constructor object
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        //Add a query condition and perform a "like" fuzzy query according to Name
        queryWrapper.like(name != null,Setmeal::getName,name);
        //Add sorting criteria, sorted by update time in descending order
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        setmealService.page(pageInfo,queryWrapper);

        //Copy the object
        BeanUtils.copyProperties(pageInfo,dtoPage,"records");
        List<Setmeal> records = pageInfo.getRecords();

        List<SetmealDto> list = records.stream().map((item) -> {
            SetmealDto setmealDto = new SetmealDto();
            //Copy the object
            BeanUtils.copyProperties(item,setmealDto);
            //id
            Long categoryId = item.getCategoryId();
            //Query the classification object based on the classification ID
            Category category = categoryService.getById(categoryId);
            if(category != null){
                //Class Name
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());

        dtoPage.setRecords(list);
        return R.success(dtoPage);
    }

    /**
     * Delete the package
     * @param ids
     * @return
     */
    @DeleteMapping
    @CacheEvict(value = "setmealCache",allEntries = true)
    @ApiOperation(value = "Package delete connection口")
    public R<String> delete(@RequestParam List<Long> ids){
        log.info("ids:{}",ids);

        setmealService.removeWithDish(ids);

        return R.success("The plan data is deleted successfully. ");
    }

    /**
     * Query the package data based on the criteria
     * @param setmeal
     * @return
     */
    @GetMapping("/list")
    @Cacheable(value = "setmealCache",key = "#setmeal.categoryId + '_' + #setmeal.status")
    @ApiOperation(value = "Interface for querying package conditions")
    public R<List<Setmeal>> list(Setmeal setmeal){
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(setmeal.getCategoryId() != null,Setmeal::getCategoryId,setmeal.getCategoryId());
        queryWrapper.eq(setmeal.getStatus() != null,Setmeal::getStatus,setmeal.getStatus());
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);

        List<Setmeal> list = setmealService.list(queryWrapper);

        return R.success(list);
    }
}
