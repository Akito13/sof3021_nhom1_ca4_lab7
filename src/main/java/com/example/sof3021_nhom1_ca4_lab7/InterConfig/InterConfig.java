package com.example.sof3021_nhom1_ca4_lab7.InterConfig;

import com.example.sof3021_nhom1_ca4_lab7.Service.GlobalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterConfig implements WebMvcConfigurer {

    @Autowired
    GlobalInterceptor global;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(global)
                .addPathPatterns("/**")
                .excludePathPatterns("/assets/**");
    }
}
