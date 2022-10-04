package com.asd.backened.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.asd.backened.entity.User;
import com.asd.backened.mapper.UserMapper;
import com.asd.backened.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
}
