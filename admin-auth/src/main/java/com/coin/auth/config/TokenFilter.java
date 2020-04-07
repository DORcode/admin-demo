package com.coin.auth.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.coin.auth.util.ApplicationContextUtil;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.util.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    // AuthenticatingFilter

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        String token1 = request.getParameter("token");
        YmlConfig config = (YmlConfig) ApplicationContextUtil.getBeanObj("ymlConfig");
        if(StringUtils.isNotEmpty(token)) {
            if(config.isExpire(token)) {
                return false;
            } else {
                return true;
            }
        } else if(StringUtils.isNotEmpty(token1)) {
            if(config.isExpire(token)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        String token1 = request.getParameter("token");
        BaseException exception = new BaseException(ResultCodeEnum.UNLOGIN);
        YmlConfig config = (YmlConfig) ApplicationContextUtil.getBeanObj("ymlConfig");
        if(StringUtils.isNotEmpty(token)) {
            if(config.isExpire(token)) {
                exception = new BaseException(ResultCodeEnum.TOKEN_EXPIRE);
            }
        } else if(StringUtils.isNotEmpty(token1)) {
            if(config.isExpire(token)) {
                exception = new BaseException(ResultCodeEnum.TOKEN_EXPIRE);
            }
        } else {
            exception = new BaseException(ResultCodeEnum.UNLOGIN);
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JSONObject.toJSONString(Result.fail(exception)));
        return false;
    }
}
