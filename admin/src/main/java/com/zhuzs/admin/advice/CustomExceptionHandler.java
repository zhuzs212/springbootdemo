package com.zhuzs.admin.advice;

import com.zhuzs.admin.common.BaseResponse;
import com.zhuzs.admin.common.ExceptionConstantEnum;
import com.zhuzs.admin.common.SysExceptionEnum;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.utils.BaseResponseUtil;
import com.zhuzs.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

/**
  * 自定义异常处理器
  *
  * @Author zhu_zishuang
  * @Date 2020-09-17
  */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 数据校验异常 及 系统异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponse handleBindException(Exception e, HttpServletRequest request) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            log.error(Constant.LOG_INFO_PREFIX, methodArgumentNotValidException.getMessage());
            return BaseResponseUtil.fail(ExceptionConstantEnum.PARAMS_NOT_RIGHT.getCode(), methodArgumentNotValidException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        }
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            log.error(Constant.LOG_INFO_PREFIX, bindException.getMessage());
            return BaseResponseUtil.fail(ExceptionConstantEnum.PARAMS_NOT_RIGHT.getCode(), bindException.getMessage());

        }
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            log.error(Constant.LOG_INFO_PREFIX, constraintViolationException.getMessage());
            return BaseResponseUtil.fail(ExceptionConstantEnum.PARAMS_NOT_RIGHT.getCode(), constraintViolationException.getMessage());
        }
        // SQL 操作异常
        if (e instanceof SQLException) {
            SQLException sqlException = (SQLException) e;
            log.error("SQL异常，异常信息：{}", sqlException.getMessage());
            return BaseResponseUtil.fail(ExceptionConstantEnum.SQL_ERROR_EXCEPTION.getCode(), sqlException.getMessage());

        }
        log.error("系统异常，异常信息：{}", e.getMessage());
        return BaseResponseUtil.error(SysExceptionEnum.SYS_EXCEPTION);
    }

    /**
     * log.error("发生系统异常，异常信息：{}", exception.getMessage());
     * 业务异常
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public BaseResponse handleServiceException(ServiceException e, HttpServletRequest request) {
        // 打印业务异常日志
        log.error("接口: {} 异常，异常状态码 {}，异常信息：{}", request.getRequestURI(), ExceptionConstantEnum.ACCOUNT_NOT.getCode(), ExceptionConstantEnum.ACCOUNT_NOT.getMessage(), e);
        return BaseResponseUtil.fail(ExceptionConstantEnum.ACCOUNT_NOT);
    }

}
