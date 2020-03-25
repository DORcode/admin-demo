package com.coin.auth.config;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtProperty
 * @Description: TODO
 * @Author kh
 * @Date 2020/2/26 16:57
 * @Version V1.0
 **/
@Data
@ConfigurationProperties(prefix = "app")
@Component
public class YmlConfig {

    private Jwt jwt;

    private Encrypt encrypt;

//    /**
//     * 密钥
//     */
//    private String secret;
//    /**
//     * 过期时间(秒)
//     */
//    private long expire;
//
//    private String header;

//    private String salt;
//
//    private int iteration;
    
    /**
     * @MethodName createJwt
     * @Description TODO
     * @param username 
     * @return java.lang.String
     * @throws 
     * @author kh
     * @date 2020/2/27 9:33
     */
    public String createJwt(String id, String username) {
        Date now = new Date();
        Date date = new Date(now.getTime() + jwt.getExpire() * 1000);
        Map claims = new HashMap<>();
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setExpiration(date)
            .setSubject(username)
            //.setClaims(claims)
            //.setId("")
            .setIssuedAt(now)
            .signWith(SignatureAlgorithm.ES512, jwt.getHeader())
            .compact();
    }

    public Map createJwtMap(String id, String username) {
        Date now = new Date();
        Date date = new Date(now.getTime() + jwt.getExpire() * 1000);
        Map claims = new HashMap<>();
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setExpiration(date)
                .setSubject(username)
                //.setClaims(claims)
                //.setId("")
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.ES512, jwt.getHeader())
                .compact();
        Map map = new HashMap<>();
        map.put("token", jwt);
        map.put("tokenExpireTime", date);
        return map;
    }
    
    
    /**
     * @MethodName getTokenClaim
     * @Description TODO
     * @param token 
     * @return io.jsonwebtoken.Claims
     * @throws 
     * @author kh
     * @date 2020/2/27 9:33
     */
    public Claims getTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(jwt.getSecret()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * @MethodName isExpire
     * @Description TODO
     * @param token 
     * @return boolean
     * @throws 
     * @author kh
     * @date 2020/2/27 9:33
     */
    public boolean isExpire(String token) {
        Claims claims = getTokenClaim(token);
        if(null != claims) {
            return claims.getExpiration().before(new Date());
        } else {
            return false;
        }
    }

    @Data
    class Jwt {
        /**
         * 密钥
         */
        private String secret;
        /**
         * 过期时间(秒)
         */
        private long expire;

        private String header;
    }

    @Data
    class Encrypt {

        private String salt;

        private int iteration;
    }
}
