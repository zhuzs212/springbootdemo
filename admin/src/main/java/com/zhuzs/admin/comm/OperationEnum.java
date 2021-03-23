package com.zhuzs.admin.comm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 全局枚举常量类
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Accessors(chain = true)
@AllArgsConstructor
public enum OperationEnum implements ExceptionInterface {
    /**
     * 登陆成功
     */
    LOGIN_SUCCESS(200, "登陆成功！"),
    /**
     * 新增操作成功
     */
    SAVE_SUCCESS(201, "新增成功！"),
    /**
     * 修改操作成功
     */
    UPDATE_SUCCESS(202, "修改成功！"),
    /**
     * 删除操作成功
     */
    DELETE_SUCCESS(203, "删除成功！");
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
