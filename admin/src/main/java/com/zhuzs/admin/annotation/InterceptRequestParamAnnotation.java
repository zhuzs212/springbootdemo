package com.zhuzs.admin.annotation;

import java.lang.annotation.*;

/**
 * 拦截请求参数自定义注解
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InterceptRequestParamAnnotation {
}
