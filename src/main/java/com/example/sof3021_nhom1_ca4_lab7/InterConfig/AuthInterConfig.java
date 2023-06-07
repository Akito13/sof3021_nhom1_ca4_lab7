package com.example.sof3021_nhom1_ca4_lab7.InterConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthInterConfig  implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor auth;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auth).addPathPatterns("/account/**","/order/**", "/admin/**")
                .excludePathPatterns("/assets/**","/account/login", "/admin/index");
    }
}
