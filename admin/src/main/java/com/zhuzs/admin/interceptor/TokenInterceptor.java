package com.zhuzs.admin.interceptor;

import com.zhuzs.admin.annotation.jwt.IgnorePermissions;
import com.zhuzs.admin.constant.Constant;
import com.zhuzs.admin.constant.SysExceptionEnum;
import com.zhuzs.admin.service.exception.ServiceException;
import com.zhuzs.admin.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 配置Token拦截器
 *
 * @author zhu_zishuang
 * @date 3/20/21
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 判断请求映射的方式是否忽略权限验证
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(IgnorePermissions.class)) {
            return true;
        }

        // 地址过滤,含有'token'的均需要验证
//        String uri = request.getRequestURI();
//        if (uri.contains("login")) {
//            return true;
//        }

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
        //设置 identityId 用户身份ID
        request.setAttribute("identityId", claims.getSubject());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}