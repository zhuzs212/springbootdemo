package com.zhuzs.admin.entity.param;

import lombok.Data;

/**
 * 新增用户 请求参数
 *
 * @Author zhu_zishuang
 * @Date 2020-09-16
 */
@Data
public class SaveUserParam {
    /**
     * 姓名
     */

    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;
}

