package com.zhuzs.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
  * @Description web配置类 跨域
  *
  * @Author zhu_zishuang
  * @Date 2020-04-25 19:21
  */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 跨域处理
     *
     * @param registry 注册对象
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*", "null")
            .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE", "HEAD").maxAge(3600).allowCredentials(true)
            .allowedHeaders("Origin", "Content-Type", "Accept", "authorization", "sessionId", "fileName")
            .exposedHeaders("sessionId", "fileName");
    }
}