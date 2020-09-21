package com.zhuzs.admin.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 全局枚举常量类
 *
 * @author: zhu_zishuang
 * @date: 2020-09-17
 */
@AllArgsConstructor
public enum OperationEnum {
    /**
     * 新增操作成功
     */
    SAVE_SUCCESS(201,"新增成功！"),
    /**
     * 修改操作成功
     */
    UPDATE_SUCCESS(202,"修改成功！"),
    /**
     * 删除操作成功
     */
    DELETE_SUCCESS(203,"删除成功！");
    /**
     * 结果类型CODE
     */
    @Getter
    private final int code;

    /**
     * 结果类型描述
     */
    @Getter
    private final String message;
}
