package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
@Aspect
public class AopTest {
    //配置接入点
    @Pointcut("execution(* com.example.demo.*.controller..*.*(..))")
    //定义一个切入点
    private void controllerAspect() {
    }

    @Before("execution(* com.example.demo.*.controller..*.getAll())")
    public void before(JoinPoint joinPoint) {
        // System.out.println("Aop before");
    }

    @After("execution(* com.example.demo.*.controller..*.getAll())")
    public void after(JoinPoint joinPoint) {
        // System.out.println("Aop end");
    }
}
