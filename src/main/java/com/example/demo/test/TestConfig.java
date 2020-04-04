package com.example.demo.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.demo.test.mapper")
public class TestConfig {
}
