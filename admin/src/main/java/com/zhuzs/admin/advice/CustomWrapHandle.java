package com.zhuzs.admin.advice;

import com.zhuzs.admin.support.BaseResponseCode;
import com.zhuzs.admin.support.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @description：
 * @author: zhu_zishuang
 * @date: 2020-04-24 14:01
 */
@ControllerAdvice
@Slf4j
public class CustomWrapHandle<T> implements ResponseBodyAdvice<T> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        System.out.println(" ClassName: "+body.getClass().getName());
        /**
         * 业务异常信息
         */
        if (body.getClass().equals(BaseResponse.class)) {
            // 打印业务异常日志
            log.error("接口: {} ", "业务异常！");
            return body;
        }
        /**
         * 增、删、改操作返回的状态
         */
        if (body.getClass().equals(BaseResponseCode.class)) {
            log.error("接口: {} ", "增删改方法！");
            BaseResponseCode resultCode = (BaseResponseCode)body;
            return (T) new BaseResponse().ok(resultCode.code,resultCode.message);
        }

        return (T) new BaseResponse().ok(body);
    }
}

