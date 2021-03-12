package com.zhuzs.admin.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色映射实体
 *
 * @author zhu_zishuang
 * @date 2020-10-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDO {
    /**
     * 角色ID
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;
}