package com.zhuzs.admin.service;

import com.zhuzs.entity.admin.User;
import org.springframework.stereotype.Service;

/**
 * @description：user service接口
 *
 * @author: zhu_zishuang
 * @date: 2020-04-22 15:27
 */
public interface UserService {
    User findUser();
}
