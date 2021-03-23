package com.zhuzs.admin.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * jwt 配置类
 *
 * @author zhu_zishuang
 * @date 3/20/21
 */
//@ConfigurationProperties(prefix = "config.jwt")
@Component
@Data
public class JwtConfig {
    /**
     * 加密密钥
     */
    private String secret = "iwqjhda8232bjgh432[cicada-smile]";
    /**
     * token有效时长
     */
    private long expire =  3600;
    /**
     * header 名称
     */
    private String header = "token";

    /**
     * 根据身份ID标识，生成Token
     * @param identityId 身份ID
     * @return token
     */
    public String getToken (String identityId){
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(identityId)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 获取 Token 中注册信息
     * @param token token
     * @return 用户注册信息
     */
    public Claims getTokenClaim (String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Token 是否过期验证
     *
     * @param expirationTime token过期时间节点
     * @return  是或否
     */
    public boolean isTokenExpired (Date expirationTime) {
        return expirationTime.before(new Date());
    }
}