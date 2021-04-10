package com.zhuzs.admin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt 配置类
 *
 * @author zhu_zishuang
 * @date 3/20/21
 */
@Component
public class JwtUtil {
    /**
     * jwt秘钥
     */
    private static final String SECRET = "KfxcZITlSBpzE2mgb3eJno";

    /**
     * token有效时长(s)
     */
    private static final Long EXPIRE = 3600_000_000L;

    /**
     * 私有化 构造方法
     */
    private JwtUtil(){

    }
    /**
     * 根据身份ID标识，生成Token
     *
     * @param identityId 身份ID
     * @return token
     */
    public static String getToken(String identityId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + EXPIRE);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(identityId)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * 获取 Token 中注册信息
     *
     * @param token token
     * @return 用户注册信息
     */
    public static Claims getTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Token 是否过期验证
     *
     * @param expirationTime token过期时间节点
     * @return 是或否
     */
    public static boolean isTokenExpired(Date expirationTime) {
        return expirationTime.before(new Date());
    }
}