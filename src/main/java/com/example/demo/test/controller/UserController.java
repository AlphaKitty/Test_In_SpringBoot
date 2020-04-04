package com.example.demo.test.controller;


import com.example.demo.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-03-12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/all")
    @ResponseBody
    public Object getAll() {
        AsynLock();
        return userServiceImpl.getAll();
    }

    private void AsynLock() {
        Jedis jedis = new Jedis("127.0.0.1", 9527);
        Long lock = jedis.setnx("lock", "1");
        if (lock == 0) {
            jedis.incr("temp");
            System.out.println("这时第 " + jedis.get("temp") + " 次请求");
        } else {
            AsynLock();
        }
    }
}
