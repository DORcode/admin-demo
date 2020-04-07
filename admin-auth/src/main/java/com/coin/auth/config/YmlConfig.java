package com.coin.auth.config;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
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
@Component
@ConfigurationProperties(prefix = "app")
public class YmlConfig {
    @Value("${app.encrypt.salt}")
    private String salt;

    @Value("${app.encrypt.iteration}")
    private Integer iteration;

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expire}")
    private Integer expire;

    @Value("${app.jwt.header}")
    private String header;
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
        Date date = new Date(now.getTime() + expire * 1000);
        Map claims = new HashMap<>();
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setExpiration(date)
            .setSubject(username)
            //.setClaims(claims)
            //.setId("")
            .setIssuedAt(now)
            .signWith(SignatureAlgorithm.ES512, header)
            .compact();
    }

    public Map createJwtMap(String id, String username) {
        Date now = new Date();
        long num = now.getTime() + expire * 1000;
        Date date = new Date(now.getTime() + expire * 1000);
        Map claims = new HashMap<>();
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setExpiration(date)
                .setSubject(username)
                .claim("id", id)
                //.setClaims(claims)
                //.setId("")
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        Map map = new HashMap<>();
        map.put("token", token);
        map.put("tokenExpireTime", num);
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
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
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

    public class Jwt {
        /**
         * 密钥
         */
        private String secret;
        /**
         * 过期时间(秒)
         */
        private long expire;

        private String header;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public long getExpire() {
            return expire;
        }

        public void setExpire(long expire) {
            this.expire = expire;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }

    public class Encrypt {

        private String salt;

        private int iteration;

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getIteration() {
            return iteration;
        }

        public void setIteration(int iteration) {
            this.iteration = iteration;
        }
    }
}
