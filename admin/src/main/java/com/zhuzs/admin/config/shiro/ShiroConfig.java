//package com.zhuzs.admin.config.shiro;
//
//import com.zhuzs.admin.config.shiro.MyRealm;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * shiro 配置类
// *
// * @author zhu_zishuang
// * @date 2021-03-12
// */
//@Configuration
//public class ShiroConfig {
//    /**
//     * 创建 realm 对象，需要自己定义
//     *
//     * @return
//     */
//    @Bean
//    public MyRealm userRealm() {
//        return new MyRealm();
//    }
//
//    /**
//     * 配置安全管理器 SecurityManager
//     *
//     * @return
//     */
//    @Bean
//    public DefaultWebSecurityManager securityManager() {
//        // 将自定义 Realm 加进来
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        // 关联 Realm
//        securityManager.setRealm(userRealm());
//        return securityManager;
//    }
//
//    /**
//     * 配置 Shiro 过滤器
//     *
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//        factoryBean.setSecurityManager(securityManager);
//        Map<String, String> map = new HashMap<>();
//        map.put("/main", "authc");
//        map.put("/manage", "perms[manage]");
//        map.put("/admin", "roles[admin]");
//        factoryBean.setFilterChainDefinitionMap(map);
//        //设置登录页面
//        factoryBean.setLoginUrl("/login");
//        //未授权页面
//        factoryBean.setUnauthorizedUrl("/unauth");
//        return factoryBean;
//    }
//
//}
//
