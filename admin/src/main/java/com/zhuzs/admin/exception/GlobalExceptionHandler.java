package com.zhuzs.admin.exception;

import com.zhuzs.common.Constant;
import com.zhuzs.admin.support.Result;
import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

/**
 * @description：全局异常处理
 * @author: zhu_zishuang
 * @date: 2020-04-23 09:51
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /***
     * 日志
     */
    public final Logger logger;

    {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * 进行异常处理
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public Result handleException(ServiceException e, HttpServletRequest request) {
        Result result = new Result(Constant.ReqResult.FAIL, ResultCode.ACCOUNT_NOT);
        // 打印业务异常日志
        logger.error("接口: {} 异常，异常状态码 {}，异常信息：{}", request.getRequestURI(), result.getCode(), result.getMessage(), e);
        return result;

    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest req, Exception e) {
        logger.error("未知异常！原因是:", e.getMessage());
        return new Result(Constant.ReqResult.ERROR, ResultCode.INTERNAL_SERVER_ERROR);
    }
}

