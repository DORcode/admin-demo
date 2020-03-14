package com.coin.auth.config.shiro;

import com.coin.auth.web.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName ShiroUtil
 * @Description: TODO
 * @Author kh
 * @Date 2020/3/8 21:43
 * @Version V1.0
 **/
public class ShiroUtil {

    /**
     * @MethodName getUserId
     * @Description 获取当前用户的主键
     * @param
     * @return java.lang.String
     * @throws
     * @author kh
     * @date 2020/3/8 21:46
     */
    public static String getUserId() {
        Subject subject = SecurityUtils.getSubject();
        SysUser principal = (SysUser) subject.getPrincipal();
        if(null != principal) {
            return principal.getId();
        } else {
            return null;
        }
    }
}
