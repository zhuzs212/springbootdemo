package com.zhuzs.admin.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * jwt配置项
 * <p>
 * 动态的写配置文件,相当于在yml中写配置
 *
 * @author zhu_zishuang
 * @date 3/23/21
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "project.jwt")
public class JwtProjectProperties {

    /**
     * jwt秘钥
     */
    private String secret = "mySecret";

    /**
     * token有效时长(s)
     */
    private Integer expire = 3600;

    /**
     * header 名称
     */
    private String header = "token";

    /**
     * 权限模式-路径拦截
     */
    private boolean patternPath = true;

    /**
     * 权限模式-注解拦截
     */
    private boolean patternAnno = true;
}
