package com.zhuzs.admin.annotation;

import java.lang.annotation.*;

/**
 * 拦截请求参数自定义注解
 *
 * @author: zhu_zishuang
 * @date: 2020-11-25
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InterceptRequestParamAnnotation {
}
