package com.coin.auth.config;

import com.coin.auth.util.BaseException;
import com.coin.auth.util.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TokenFilter
 * @Description: 过滤token
 * @Author kh
 * @Date 2020/2/29 14:26
 * @Version V1.0
 **/
public class TokenFilter extends AccessControlFilter {
    @Autowired
    private YmlConfig ymlConfig;

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        String token1 = request.getParameter("token");
        if(StringUtils.isNotEmpty(token)) {
            if(ymlConfig.isExpire(token)) {
                throw new BaseException(ResultCodeEnum.TOKEN_EXPIRE);
            } else {
                return true;
            }
        } else if(StringUtils.isNotEmpty(token1)) {
            if(ymlConfig.isExpire(token)) {
                throw new BaseException(ResultCodeEnum.TOKEN_EXPIRE);
            } else {
                return true;
            }
        } else {
            throw new BaseException(ResultCodeEnum.UNLOGIN);
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {

        return false;
    }
}
