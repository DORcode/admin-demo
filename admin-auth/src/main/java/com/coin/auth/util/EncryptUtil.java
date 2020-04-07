package com.coin.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.Date;

/**
 * @ClassName EncryptUtil
 * @Description: TODO
 * @Author kh
 * @Date 2020/2/29 12:22
 * @Version V1.0
 **/
public class EncryptUtil {

    public static String md5(String str, String salt, int iteration) {
        return new SimpleHash("md5", str, salt, iteration).toHex();
    }

    public static Claims getTokenClaim(String secret, String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isExpire(String secret, String token) {
        Claims claims = getTokenClaim(secret, token);
        if(null != claims) {
            return claims.getExpiration().before(new Date());
        } else {
            return false;
        }
    }
}
