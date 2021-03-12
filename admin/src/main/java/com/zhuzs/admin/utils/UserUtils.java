package com.zhuzs.admin.utils;

import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.exception.SysExceptionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * 用户工具类
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Component
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
            throw new ServiceException(SysExceptionEnum.ACCOUNT_NOT_EXIST);
        }
    }
}