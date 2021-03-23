package com.zhuzs.admin.interceptor;

import com.zhuzs.admin.comm.SysExceptionEnum;
import com.zhuzs.admin.exception.ServiceException;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置Token拦截器
 * 
 * @author zhu_zishuang
 * @date 3/20/21
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private JwtConfig jwtConfig ;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 地址过滤
        String uri = request.getRequestURI() ;
        if (uri.contains("/token")){
            return true ;
        }
        // Token 验证
        String token = request.getHeader(jwtConfig.getHeader());
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(jwtConfig.getHeader());
        }
        if(StringUtils.isEmpty(token)){
            // token 为空，鉴权失败
            throw new ServiceException(SysExceptionEnum.TOKEN_IS_EMPTY);
        }
        Claims claims = jwtConfig.getTokenClaim(token);
        if(claims == null || jwtConfig.isTokenExpired(claims.getExpiration())){
            // token 已失效
            throw new ServiceException(SysExceptionEnum.TOKEN_EXPIRED_EXCEPTION);
        }
        //设置 identityId 用户身份ID
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }
}