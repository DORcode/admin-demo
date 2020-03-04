package com.coin.auth.util;

import org.apache.shiro.crypto.hash.SimpleHash;

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
}
