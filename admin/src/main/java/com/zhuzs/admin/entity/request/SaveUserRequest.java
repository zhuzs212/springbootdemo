package com.zhuzs.admin.entity.request;

import com.zhuzs.admin.comm.validated.Insert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * 新增用户 请求参数
 *
 * @author zhu_zishuang
 * @date 2020-09-16
 */
@Data
@ToString
@ApiModel(value = "新增用户请求入参实体")
public class SaveUserRequest {
    /**
     * 姓名
     */

    @NotEmpty(message = "用户名不能为空！")
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", required = true)
    private Integer age;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式错误！", groups = {Insert.class})
    @ApiModelProperty(value = "邮箱", required = true)
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式不正确！ ")
    private String email;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    @NotNull(message = "创建时间不能为空！")
    private LocalDateTime createTime;
}

