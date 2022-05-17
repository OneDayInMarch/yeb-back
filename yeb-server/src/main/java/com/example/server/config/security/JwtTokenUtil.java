package com.example.server.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * Jwt Token工具类
 */
@Component
public class JwtTokenUtil {
    //下面是常量
    //荷载里面的用户名
    private static final String CLAIM_KEY_USERNAME = "sub";
    //荷载里面的创建时间
    private static final String CLAIM_KEY_CREATED = "created";
    //秘钥通过value注解去拿
    @Value("${jwt.secret}")
    private String secret;
    //失效时间
    @Value("${jwt.expiration}")
    private Long expiration;
    /**
     * 根据负载生成JWT Token
     *
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                //设置生成，并且设置荷载
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                //失效时间
                .signWith(SignatureAlgorithm.HS512, secret)
                //签名
                .compact();
    }
    /**
     * 从token中获取JWT中的负载
     *
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }
    /**
     * 从token获取用户信息
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username = null;
        Claims claims = getClaimsFromToken(token);
        try {
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    /**
     * 生成token过期时间
     *
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
    /**
     * 从token中获取过期时间
     *
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
    /**
     * 判断token是否失效
     *
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 验证token是否有效
     *
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) &&
                !isTokenExpired(token);
    }
    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        //这个就是我们的荷载
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
    // Admin实现UserDetails类
    /**
     * 判断token是否可以被刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }
    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }
}
