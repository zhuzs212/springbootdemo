package com.zhuzs.admin.controller.tokencontroller;

import com.zhuzs.admin.annotation.jwt.JwtPermissions;
import com.zhuzs.admin.constant.OperationEnum;
import com.zhuzs.admin.utils.JwtUtil;
import com.zhuzs.admin.entity.request.LoginUserRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * JWT 测试
 *
 * @author zhu_zishuang
 * @date 3/20/21
 */
@RestController
@RequestMapping("/token")
public class TokenController {
    @Resource
    private JwtUtil jwtConfig;

    /**
     * 拦截器直接放行，返回Token
     *
     * @return
     */
    @PostMapping("/login")
    public OperationEnum login(@RequestBody LoginUserRequest request, HttpServletResponse response) {
        // 省略数据源校验
        String token = jwtConfig.getToken(request.getName() + request.getPassword());
        response.setHeader("token", token);
        return OperationEnum.LOGIN_SUCCESS;
    }

    /**
     * 需要 Token 验证的接口
     *
     * @return
     */
    @JwtPermissions
    @PostMapping("/info")
    public String info() {
        return "info";
    }
}