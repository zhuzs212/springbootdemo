package com.zhuzs.admin.comm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.concurrent.TimeUnit;

/**
 * redis 过期时间枚举
 *
 * @author zhu_zishuang
 * @date 2020-08-06
 */
@Accessors(chain = true)
@AllArgsConstructor
public enum ExpireEnum {
    //未读消息的有效期为30天
    UNREAD_MSG(30L, TimeUnit.DAYS);

    /**
     * 过期时间
     */
    @Getter
    private Long time;
    /**
     * 时间单位
     */
    @Getter
    private TimeUnit timeUnit;
}