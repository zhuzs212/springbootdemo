package com.zhuzs.admin.controller.tokencontroller;

import com.zhuzs.admin.comm.OperationEnum;
import com.zhuzs.admin.interceptor.JwtConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private JwtConfig jwtConfig;

    /**
     * 拦截器直接放行，返回Token
     *
     * @param userName 用户名
     * @param passWord 密码
     * @return
     */
    @PostMapping("/login")
    public OperationEnum login(@RequestParam("userName") String userName,
                               @RequestParam("passWord") String passWord, HttpServletResponse response) {
        // 省略数据源校验
        String token = jwtConfig.getToken(userName + passWord);
        response.setHeader("token", token);
        return OperationEnum.LOGIN_SUCCESS;
    }

    /**
     * 需要 Token 验证的接口
     *
     * @return
     */
    @PostMapping("/info")
    public String info() {
        return "info";
    }
}