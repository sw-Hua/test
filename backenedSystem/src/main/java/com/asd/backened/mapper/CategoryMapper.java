package com.asd.backened.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.asd.backened.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
