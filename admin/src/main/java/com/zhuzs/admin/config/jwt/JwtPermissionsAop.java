package com.zhuzs.admin.config.jwt;

import com.zhuzs.admin.constant.Constant;
import com.zhuzs.admin.constant.SysExceptionEnum;
import com.zhuzs.admin.service.exception.ServiceException;
import com.zhuzs.admin.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Jwt权限注解AOP
 * 通过注解拦截，只需要在需要拦截的接口上添加@JwtPermissions即可
 *
 * @author zhu_zishuang
 * @date 3/23/21
 */
@Aspect
@Component
@ConditionalOnProperty(name = "project.jwt.pattern-anno", havingValue = "true", matchIfMissing = true)
public class JwtPermissionsAop {
    @Resource
    private HttpServletRequest request;

    @Pointcut("@annotation(com.zhuzs.admin.annotation.jwt.JwtPermissions)")
    public void jwtPermissions() {
    }

    @Around("jwtPermissions()")
    public Object doPermission(ProceedingJoinPoint point) throws Throwable {


        // Token 验证
        String token = request.getHeader(Constant.HEADER);
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter(Constant.HEADER);
        }
        if (StringUtils.isEmpty(token)) {
            // token 为空，鉴权失败
            throw new ServiceException(SysExceptionEnum.TOKEN_IS_EMPTY);
        }
        Claims claims = JwtUtil.getTokenClaim(token);
        if (claims == null || JwtUtil.isTokenExpired(claims.getExpiration())) {
            // token 已失效
            throw new ServiceException(SysExceptionEnum.TOKEN_EXPIRED_EXCEPTION);
        }

        return point.proceed();
    }
}
