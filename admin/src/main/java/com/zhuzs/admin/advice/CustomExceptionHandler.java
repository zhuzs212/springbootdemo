package com.zhuzs.admin.advice;

import com.zhuzs.admin.common.BaseResponseCode;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.common.BaseResponse;
import com.zhuzs.admin.utils.BaseResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @description：全局异常处理
 * @author: zhu_zishuang
 * @date: 2020-04-23 09:51
 */
@ControllerAdvice
public class CustomExceptionHandler {
    /***
     * 日志
     */
    public final Logger logger;

    {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * 数据校验异常 及 系统异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleBindException(Exception e, HttpServletRequest request) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            return BaseResponseUtil.fail(BaseResponseCode.PARAMS_NOT_RIGHT.code,methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            return BaseResponseUtil.fail(BaseResponseCode.PARAMS_NOT_RIGHT.code,bindException.getMessage());

        }
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            return BaseResponseUtil.fail(BaseResponseCode.PARAMS_NOT_RIGHT.code,constraintViolationException.getMessage());
        }
        return BaseResponseUtil.error();
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public BaseResponse handleServiceException(ServiceException e, HttpServletRequest request) {
        // 打印业务异常日志
        logger.error("接口: {} 异常，异常状态码 {}，异常信息：{}", request.getRequestURI(), BaseResponseCode.ACCOUNT_NOT.code, BaseResponseCode.ACCOUNT_NOT.message, e);
        return BaseResponseUtil.fail(BaseResponseCode.ACCOUNT_NOT);
    }

}
