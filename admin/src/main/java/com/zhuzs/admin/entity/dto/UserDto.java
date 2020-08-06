package com.zhuzs.admin.entity.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhuzs.admin.entity.User;
import com.zhuzs.admin.entity.vo.UserVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @title：User
 * @project_name: springbootdemo
 * @description：用户
 * @author: zhu_zishuang
 * @date: 2020-04-21 10:33
 */
@Data
@ToString
@ApiModel("用户实体类")
public class UserDto extends User {
    private static final long serialVersionUID = -6716772084974704679L;
    /**
     * JSON 数据
     */
    @ApiModelProperty("JSON 数据")
    String jsonData;

    /**
     * 分页数据
     */
    @ApiModelProperty("分页数据")
    Page<UserVo> page = new Page<>();
}

