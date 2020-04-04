package com.example.demo;

import com.example.demo.config.InterceptorTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JavaConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorTest interceptorTest;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorTest);
    }
}
