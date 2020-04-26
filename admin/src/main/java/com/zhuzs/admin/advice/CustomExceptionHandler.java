package com.zhuzs.admin.advice;

import com.zhuzs.admin.exception.ResultCode;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.support.Result;
import com.zhuzs.common.Constant;
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
    public Result handleBindException(Exception e, HttpServletRequest request) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            return new Result().setStatus(Constant.ReqResult.FAIL).setCode(ResultCode.PARAMS_NOT_RIGHT.code).setMessage(methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            return new Result().setStatus(Constant.ReqResult.FAIL).setCode(ResultCode.PARAMS_NOT_RIGHT.code).setMessage(bindException.getMessage());
        }
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            return new Result().setStatus(Constant.ReqResult.FAIL).setCode(ResultCode.PARAMS_NOT_RIGHT.code).setMessage(constraintViolationException.getMessage());
        }
        return new Result().setStatus(Constant.ReqResult.ERROR).setCode(ResultCode.INTERNAL_SERVER_ERROR.code).setMessage(ResultCode.INTERNAL_SERVER_ERROR.message);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Result handleServiceException(ServiceException e, HttpServletRequest request) {
        // 打印业务异常日志
        logger.error("接口: {} 异常，异常状态码 {}，异常信息：{}", request.getRequestURI(), ResultCode.ACCOUNT_NOT.code, ResultCode.ACCOUNT_NOT.message, e);
        return new Result().setStatus(Constant.ReqResult.FAIL).setCode(ResultCode.ACCOUNT_NOT.code).setMessage(ResultCode.ACCOUNT_NOT.message);
    }

}
