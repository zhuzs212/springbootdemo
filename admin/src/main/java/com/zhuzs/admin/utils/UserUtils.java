package com.zhuzs.admin.utils;

import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.service.constant.ExceptionConstantEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @author xyyxhcj@qq.com
 * @since 2018-08-28
 */
@Component
@SuppressWarnings("all")
public class UserUtils {
    /**
     * 获取UserInfo
     */
    @NotNull
    public static UserDO getUserDO() {
        // 从shiro中获取
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        if (principals != null) {
            Object userVo = principals.getPrimaryPrincipal();
            return (UserDO) userVo;
        } else {
            throw new ServiceException(ExceptionConstantEnum.USER_NOT_EXIT_EXCEPTION);
        }
    }
}