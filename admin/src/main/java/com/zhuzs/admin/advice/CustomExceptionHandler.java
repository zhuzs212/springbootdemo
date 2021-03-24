package com.zhuzs.admin.advice;

import com.zhuzs.admin.comm.BaseResponse;
import com.zhuzs.admin.service.exception.ServiceException;
import com.zhuzs.admin.constant.SysExceptionEnum;
import com.zhuzs.admin.utils.BaseResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.dao.DataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 自定义异常处理器
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    /**
     * 密码校验异常
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public BaseResponse<Object> handleAuthenticationException(AuthenticationException e) {
        if (e instanceof IncorrectCredentialsException) {
            log.warn("异常信息：{}", SysExceptionEnum.PASSWORD_ERROR.getMessage());
            return BaseResponseUtil.fail(SysExceptionEnum.PPARAMETER_EMPTY_EXCEPTION.getCode(), SysExceptionEnum.PASSWORD_ERROR.getMessage());
        }
        log.warn("异常信息：{}", e.getCause().getMessage());
        return BaseResponseUtil.fail(SysExceptionEnum.PPARAMETER_EMPTY_EXCEPTION.getCode(), e.getCause().getMessage());
    }

    /**
     * 校验异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn("系统参数校验异常，异常信息：", e);
        return BaseResponseUtil.fail(SysExceptionEnum.PPARAMETER_EMPTY_EXCEPTION.getCode(), e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage).collect(Collectors.joining(",")));
    }

    /**
     * 系统业务异常处理
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public BaseResponse<Object> handleServiceException(ServiceException e) {
        // 打印业务异常日志
        log.warn("系统业务逻辑异常，异常状态码 {}，异常信息：{}", e.code, e.getMessage(), e);
        return BaseResponseUtil.fail(e.code, e.getMessage());
    }

    /**
     * 系统数据访问异常处理
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public BaseResponse<Object> handleDataAccessException(DataAccessException e) {
        log.error("系统数据访问异常，异常信息：{}", e.getMessage());
        return BaseResponseUtil.error(SysExceptionEnum.SYS_EXCEPTION);
    }

    /**
     * 系统异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse<Object> handleException(Exception e) {
        log.error("系统异常，异常信息：{}", e.getMessage());
        return BaseResponseUtil.error(SysExceptionEnum.SYS_EXCEPTION);
    }

}
