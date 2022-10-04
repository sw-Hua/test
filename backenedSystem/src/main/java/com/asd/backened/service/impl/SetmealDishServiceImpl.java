package com.asd.backened.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.asd.backened.entity.SetmealDish;
import com.asd.backened.mapper.SetmealDishMapper;
import com.asd.backened.service.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper,SetmealDish> implements SetmealDishService {
}
