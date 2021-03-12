package com.zhuzs.admin.utils;

import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.exception.SysExceptionEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.validation.constraints.NotNull;

/**
 * shiro工具类
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
public class ShiroUtils {
    private ShiroUtils() {
    }

    /**
     * 校验角色
     *
     * @param roleDefi shiro角色标识
     */
    public static void checkRole(@NotNull String roleDefi) {
        if (!hasRole(roleDefi)) {
            throw new ServiceException(SysExceptionEnum.PERMISSION_NOT);
        }
    }

    /**
     * 判断是否有对应的身份，用于接口适配，动态根据用户的身份查询对应数据
     *
     * @param roleDefi roleDefi
     * @return boolean
     */
    public static boolean hasRole(@NotNull String roleDefi) {
        Subject subject = SecurityUtils.getSubject();
        return subject.hasRole(roleDefi);
    }

}