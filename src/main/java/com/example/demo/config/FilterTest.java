package com.example.demo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // System.out.println("filter begin");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // System.out.println("filtering");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // System.out.println("filter end");
    }
}
