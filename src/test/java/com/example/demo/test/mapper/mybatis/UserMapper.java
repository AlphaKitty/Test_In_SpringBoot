package com.example.demo.test.mapper.mybatis;

import com.example.demo.test.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
}
