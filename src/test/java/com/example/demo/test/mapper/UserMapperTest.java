package com.example.demo.test.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        System.out.println(userMapper.selectById("11"));
    }
}