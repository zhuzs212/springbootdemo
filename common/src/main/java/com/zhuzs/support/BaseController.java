package com.zhuzs.support;

import com.zhuzs.common.Constant;
import com.zhuzs.exception.ResultCode;
import com.zhuzs.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

/**
 * @description：公共controller
 *
 * @author: zhu_zishuang
 * @date: 2020-04-22 14:21
 */
public class BaseController {
    /***
     * 日志
     */
    public final Logger logger;
    {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }


    protected Result ok() {
        return new Result().ok();
    }

    protected <T> Result<T> ok(T data) {
        return new Result<T>().ok(data);
    }

    protected Result ok(ResultCode resultCode, Object data) {
        Result result = new Result(resultCode);
        result.setData(data);
        return result;
    }


    /**
     * 进行异常处理,该方法与出错的方法必须在同一个Controller里面,使用该方法时,所有的Controller都需要继承该类
     */
    @ExceptionHandler(Exception.class)
    @SuppressWarnings("all")
    public Result handleException(Exception e, HttpServletRequest request) {
        Result result;
        if (e instanceof LoginException) {
            result = new Result(Constant.ReqResult.FAIL, ResultCode.ACCOUNT_NOT);
        } else if (e instanceof HttpMessageNotReadableException || e instanceof HttpMediaTypeNotSupportedException) {
            result = new Result(Constant.ReqResult.FAIL, ResultCode.PARAMS_NOT);
        } else if (e instanceof ServiceException) {
            ServiceException se = (ServiceException) e;
            result = new Result(Constant.ReqResult.FAIL, se.code, se.message, se.data);
        } else {
            result = new Result(Constant.ReqResult.ERROR, ResultCode.INTERNAL_SERVER_ERROR);
        }
        // 记录业务异常日志
//        FastUtils.loggerRequestBody(logger, request);
        logger.error("接口: {} 异常，异常状态码 {}，异常信息：{}", request.getRequestURI(), result.getCode(), result.getMessage(), e);
        return result;
    }

}

