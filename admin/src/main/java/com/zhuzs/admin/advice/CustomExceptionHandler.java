package com.zhuzs.admin.advice;

import com.zhuzs.admin.exception.ResultCode;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.support.Result;
import com.zhuzs.common.Constant;
import org.apache.tomcat.util.buf.StringUtils;
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
     * 数据校验异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handleBindException(Exception e, HttpServletRequest request) {
        Result result ;
        if(e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException)e;
            result = new Result(Constant.ReqResult.FAIL, ResultCode.PARAMS_NOT_RIGHT.code, methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }else if(e instanceof BindException){
            BindException bindException = (BindException)e;
            result = new Result(Constant.ReqResult.FAIL, ResultCode.PARAMS_NOT_RIGHT.code, bindException.getMessage());
        }else if(e instanceof ConstraintViolationException){
            ConstraintViolationException constraintViolationException = (ConstraintViolationException)e;
            result = new Result(Constant.ReqResult.ERROR, ResultCode.PARAMS_NOT_RIGHT.code, constraintViolationException.getMessage());
        }else{
            result = new Result(Constant.ReqResult.FAIL, ResultCode.INTERNAL_SERVER_ERROR);
        }

        return result;
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Result handleServiceException(ServiceException e, HttpServletRequest request) {
        Result result = new Result(Constant.ReqResult.FAIL, ResultCode.ACCOUNT_NOT);
        // 打印业务异常日志
        logger.error("接口: {} 异常，异常状态码 {}，异常信息：{}", request.getRequestURI(), result.getCode(), result.getMessage(), e);
        return result;
    }

}
