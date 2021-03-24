package com.zhuzs.admin.comm;

import com.zhuzs.common.Constant;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 结果集
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
@Data
@Accessors(chain = true)
public class BaseResponse<T> {

    /**
     * success：成功，fail：业务返回的失败，error：非业务异常失败
     */
    private String status = Constant.SUCCESS;

    /**
     * 状态码
     **/
    private Integer code;

    /**
     * 结果描述
     **/
    private String message;

    /**
     * 结果数据
     **/
    private T data;
}

