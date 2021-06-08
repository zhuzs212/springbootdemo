package com.zhuzs.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 基于完全注解开发的 AOP配置
 *
 * @author zhu_zishuang
 * @date 6/8/21
 */
@Configuration
@ComponentScan(basePackages = "com.zhuzs.admin")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig {
}

