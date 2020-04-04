package com.example.demo.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.test.entity.User;
import com.example.demo.test.mapper.UserMapper;
import com.example.demo.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2020-03-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Object getAll() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return list(wrapper);
    }
}
