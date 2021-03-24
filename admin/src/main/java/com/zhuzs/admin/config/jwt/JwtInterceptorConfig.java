package com.zhuzs.admin.config.jwt;

import com.zhuzs.admin.interceptor.TokenInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 拦截器注册
 * <p>
 * 注：
 * -> @ConditionalOnProperty: 这个注解相当于读取配置文件
 *
 * @author zhu_zishuang
 * @date 3/20/21
 */
@Configuration
@ConditionalOnProperty(name = "project.jwt.pattern-path", havingValue = "true")
public class JwtInterceptorConfig implements WebMvcConfigurer {
    @Resource
    private TokenInterceptor tokenInterceptor;

    /**
     * 添加的拦截地址
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/token/login/**");
    }

}