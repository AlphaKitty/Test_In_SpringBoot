package com.example.demo.test.service;

import com.example.demo.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2020-03-12
 */
public interface IUserService extends IService<User> {

    Object getAll();
}
