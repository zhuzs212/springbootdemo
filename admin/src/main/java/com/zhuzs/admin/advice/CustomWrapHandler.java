package com.zhuzs.admin.advice;

import com.zhuzs.admin.comm.OperationEnum;
import com.zhuzs.admin.utils.BaseResponseUtil;
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
 * 自定义包装处理类
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Slf4j
@ControllerAdvice(basePackages = "com.zhuzs.admin.controller")
public class CustomWrapHandler<T> implements ResponseBodyAdvice<T> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public T beforeBodyWrite(T body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        /**
         * 增、删、改操作返回的状态
         */
        if (body.getClass().equals(OperationEnum.class)) {
            log.error("接口: {} , 增删改方法！" + request.getURI());
            return (T) BaseResponseUtil.success((OperationEnum) body);
        }

        /**
         * 读操作
         */
        return (T) BaseResponseUtil.success(body);
    }
}
