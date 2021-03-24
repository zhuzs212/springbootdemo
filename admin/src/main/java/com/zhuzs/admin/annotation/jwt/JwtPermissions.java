package com.zhuzs.admin.annotation.jwt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * jwt权限注解（需要权限）
 *
 * @author zhu_zishuang
 * @date 3/23/21
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtPermissions {

}