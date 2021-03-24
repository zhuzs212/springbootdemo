package com.zhuzs.admin.annotation.jwt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略jwt权限验证注解（只在拦截的地址内有效 /api/**）
 *
 * @author zhu_zishuang
 * @date 3/23/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IgnorePermissions {

}