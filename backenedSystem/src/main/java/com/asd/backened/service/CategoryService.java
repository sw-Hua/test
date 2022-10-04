package com.asd.backened.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.asd.backened.entity.Category;

public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
