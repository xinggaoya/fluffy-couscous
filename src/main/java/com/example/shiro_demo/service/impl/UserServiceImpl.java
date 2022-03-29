package com.example.shiro_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shiro_demo.mapper.UserMapper;
import com.example.shiro_demo.entity.User;
import com.example.shiro_demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author XingGao
 * @since 2022-03-24 14:31:20
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

