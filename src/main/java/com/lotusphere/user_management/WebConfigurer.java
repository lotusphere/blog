package com.lotusphere.user_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// @Configuration: This annotation indicates that the class is a source of bean definitions. It's a Spring configuration class that can define beans and configure components.
public class WebConfigurer implements WebMvcConfigurer {
    // WebMvcConfigurer: This interface provides callback methods to customize the configuration for Spring MVC. By implementing WebMvcConfigurer, you can add custom interceptors, formatters, view controllers, and more.
    @Autowired
    // @Autowired: This annotation is used for dependency injection. It tells Spring to automatically inject the LogInterceptor bean into this field.
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(logInterceptor);
    }
}
