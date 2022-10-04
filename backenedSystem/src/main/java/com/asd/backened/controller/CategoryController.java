package com.asd.backened.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.asd.backened.common.R;
import com.asd.backened.entity.Category;
import com.asd.backened.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**   Xuhao Guo
 * Sort management
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * The new classification
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("Classification added successfully");
    }

    /**
     * paging query
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize){
        //Page constructor
        Page<Category> pageInfo = new Page<>(page,pageSize);
        //Conditional constructor
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //Add a sort condition to sort by sort
        queryWrapper.orderByAsc(Category::getSort);

        //paging query
        categoryService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * Delete a category by ID
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long id){
        log.info("Delete a class with the ID: {}.",id);

        //categoryService.removeById(id);
        categoryService.remove(id);

        return R.success("The classification information is deleted successfully");
    }

    /**
     * Modify the classification information based on the ID
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info("Modify classification information: {}",category);

        categoryService.updateById(category);

        return R.success("The classification information is modified successfully. ");
    }

    /**
     * Query classification data based on conditions
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category){
        //Conditional constructor
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //Add the condition
        queryWrapper.eq(category.getType() != null,Category::getType,category.getType());
        //Add sort criteria
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }
}
