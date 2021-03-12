package com.zhuzs.admin.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * 校验用户基本信息切面
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Aspect
@Component
@Slf4j
public class CheckoutUserBaseInfoAspect {

    /**
     * 自定义切入点
     */
    @Pointcut(value = "@annotation(com.zhuzs.admin.annotation.InterceptRequestParamAnnotation)")
    public void targetCheckAspect() {
    }

    @Before("targetCheckAspect()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        Object target = joinPoint.getArgs()[0];
        Class<?> clss = target.getClass();
        try {
            Method method = clss.getMethod("getOrgNo");
            String orgNo = (String) method.invoke(target);
            log.info("aop拦截的入参信息：【{}】", orgNo);
            if (StringUtils.isEmpty(orgNo)) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor("orgNo", clss);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(target, "这是后台自动录入");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

