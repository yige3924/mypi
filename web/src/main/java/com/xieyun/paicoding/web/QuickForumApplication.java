package com.xieyun.paicoding.web;

import com.xieyun.paicoding.web.hook.interceptor.GlobalViewInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 应用入口
 *
 * @author XieYun
 * @date 2025/5/11
 */
@ServletComponentScan
@SpringBootApplication
public class QuickForumApplication implements WebMvcConfigurer {

    @Resource
    private GlobalViewInterceptor globalViewInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalViewInterceptor).addPathPatterns("/**");
    }

    public static void main(String[] args) {
        SpringApplication.run(QuickForumApplication.class, args);
    }
}
