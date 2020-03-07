package com.coin.auth.config;

import com.coin.auth.util.BaseException;
import com.coin.auth.util.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TokenInterceptor
 * @Description: TODO
 * @Author kh
 * @Date 2020/2/27 9:34
 * @Version V1.0
 **/
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private YmlConfig ymlConfig;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
