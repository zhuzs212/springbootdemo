package com.zhuzs.admin.service.impl;

import com.zhuzs.admin.constant.Constant;
import com.zhuzs.admin.constant.SysExceptionEnum;
import com.zhuzs.admin.entity.domain.PermissionDO;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.LoginUserRequest;
import com.zhuzs.admin.mapper.UserMapper;
import com.zhuzs.admin.service.UserService;
import com.zhuzs.admin.service.exception.ServiceException;
import com.zhuzs.admin.utils.CommonUtil;
import com.zhuzs.admin.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户接口 实现
 *
 * @author zhu_zishuang
 * @date 2020-09-17
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 注入 User 持久层
     */
    @Resource
    private UserMapper userMapper;

    @Override
    public Map<String, String> login(LoginUserRequest request) {
        // 登录用户名
        if (StringUtils.isEmpty(request.getName())) {
            throw new ServiceException(SysExceptionEnum.ACCOUNT_OR_PASSWORD_ERROR);
        }
        // 密码
        if (StringUtils.isEmpty(request.getPassword())) {
            throw new ServiceException(SysExceptionEnum.ACCOUNT_OR_PASSWORD_ERROR);
        }
        // 获取用户信息
        UserDO userDO = userMapper.getUser(request.getName());
        if (StringUtils.isEmpty(userDO)) {
            throw new ServiceException(SysExceptionEnum.ACCOUNT_OR_PASSWORD_ERROR);
        }
        // 校验密码是否正确
        if (!userDO.getPassword().equals(CommonUtil.password(request.getPassword()))) {
            throw new ServiceException(SysExceptionEnum.ACCOUNT_OR_PASSWORD_ERROR);
        }
        // 验证用户状态
        if (false) {
            throw new ServiceException(SysExceptionEnum.ACCOUNT_IS_DISABLE);
        }
        // 生成Token并返回
        String token = JwtUtil.getToken(userDO.getId() + userDO.getPassword());

        Map<String, String> result = new HashMap<>(10);
        result.put(Constant.HEADER, token);
        return result;
    }

    @Override
    @Cacheable(cacheNames = "user", key = "#name", unless = "#result == null")
    public UserDO getUser(String name) {
        return userMapper.getUser(name);
    }

    @Override
    public PermissionDO getPermission(String name) {
        return userMapper.getPermission(name);
    }
}

