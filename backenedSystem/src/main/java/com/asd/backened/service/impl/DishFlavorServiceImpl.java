package com.asd.backened.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.asd.backened.entity.DishFlavor;
import com.asd.backened.mapper.DishFlavorMapper;
import com.asd.backened.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper,DishFlavor> implements DishFlavorService {
}
