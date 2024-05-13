package com.example.Api_Interceptor.Middleware2.configuration;

import com.example.Api_Interceptor.Middleware2.interceptors.MonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private MonthInterceptor monthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(monthInterceptor).addPathPatterns("/month");
    }
}
