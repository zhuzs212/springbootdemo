package com.zhuzs.admin.controller.usercontroller;

import com.zhuzs.admin.annotation.checkparam.InterceptRequestParamAnnotation;
import com.zhuzs.admin.annotation.jwt.JwtPermissions;
import com.zhuzs.admin.controller.BaseController;
import com.zhuzs.admin.entity.domain.UserDO;
import com.zhuzs.admin.entity.request.LoginUserRequest;
import com.zhuzs.admin.entity.request.QueryUserRequest;
import com.zhuzs.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * User 控制器
 *
 * @author zhu_zishuang
 * @date 2020-09-16
 */
@RestController
@RequestMapping(value = "/user", method = {RequestMethod.POST})
@Api(tags = "用户管理")
@Slf4j
public class UserController extends BaseController {

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
    public UserDO queryUser(@RequestBody QueryUserRequest queryUserRequest, HttpServletRequest request) throws Exception {
        return userService.getUser(queryUserRequest.getName());
    }

    /**
     * 登陆接口
     *
     * @param request
     * @param model
     * @return
     * @author zhu_zishuang
     * @date 2020-10-23
     */
    @PostMapping("/login")
    @InterceptRequestParamAnnotation
    public Boolean login(@RequestBody LoginUserRequest request, Model model) {

//        // 获取 subject 认证主体（这里也就是现在登录的用户）
//        Subject subject = SecurityUtils.getSubject();
//
//        // 创建出一个 Token 内容本质基于前台的用户名和密码（不一定正确）
//        UsernamePasswordToken token = new UsernamePasswordToken(request.getName(), request.getPassword());
//
//        // 由于是根据name参数获取的，我这里封装了一下
//        UserDO user = new UserDO();
//        user.setName(request.getName());
//        user.setPassword(request.getPassword());
//        user.setOrgNo(request.getOrgNo());
//        // 认证开始，这里会跳转到自定义的 UserRealm 中
//        subject.login(token);
//        UserDO userDO = (UserDO) subject.getPrincipal();
//        subject.getSession().setAttribute("userDO", userDO);
        return true;
    }

    /**
     * 登出接口
     *
     * @param
     * @return
     * @author zhu_zishuang
     * @date 2020-10-23
     */
    @PostMapping("/logout")
    @ApiOperation("登出")
    public Boolean logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return true;
    }

    /**
     * 需要 Token 验证的接口
     *
     * @return
     */
    @PostMapping("/info")
    @JwtPermissions
    public String info() {
        return "info";
    }
}