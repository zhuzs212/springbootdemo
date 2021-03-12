package com.zhuzs.admin.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限映射实体
 *
 * @author zhu_zishuang
 * @date 2020-10-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDO {
    /**
     * 权限ID
     */
    private Integer id;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 角色
     */
    private RoleDO roleDO;
}