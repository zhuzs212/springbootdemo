package com.zhuzs.admin.controller;

import com.zhuzs.admin.annotation.InterceptRequestParamAnnotation;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.LoginUserRequest;
import com.zhuzs.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * User 控制器
 *
 * @Author zhu_zishuang
 * @Date 2020-09-16
 */
@RestController
@RequestMapping(value = "user")
@Api(tags = "用户管理")
public class UserController {

    /**
     * 注入 userService
     */
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    /**
     * 查询单个用户
     *
     * @return
     */
    @PostMapping("/queryUser")
    @ApiOperation("查询单个用户")
    public UserDO queryUser(String userName) {
//        ShiroUtils.checkRole(Constant.ADMIN);
        return userService.getUser(userName);
    }

    /**
     * 登陆接口
     *
     * @param request
     * @param model
     * @return
     * @Author zhu_zishuang
     * @Date 2020-10-23
     */
    @PostMapping("/login")
    @ApiOperation("")
    @InterceptRequestParamAnnotation
    public String login(LoginUserRequest request, Model model) {
        // 获取 subject 认证主体（这里也就是现在登录的用户）
        Subject subject = SecurityUtils.getSubject();
        // 创建出一个 Token 内容本质基于前台的用户名和密码（不一定正确）
        UsernamePasswordToken token = new UsernamePasswordToken(request.getName(), request.getPassword());

        // 由于是根据name参数获取的，我这里封装了一下
        UserDO user = new UserDO();
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setOrgNo(request.getOrgNo());
        try {
            // 认证开始，这里会跳转到自定义的 UserRealm 中
            subject.login(token);
            UserDO userDO = (UserDO) subject.getPrincipal();
            subject.getSession().setAttribute("userDO", userDO);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    /**
     * 登出接口
     *
     * @param
     * @return
     * @Author zhu_zishuang
     * @Date 2020-10-23
     */
    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}