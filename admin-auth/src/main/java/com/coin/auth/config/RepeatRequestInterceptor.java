package com.coin.auth.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @program: jplatform
 * @description: 重复提交拦截
 * @author: kh
 * @create: 2018-12-03 15:27:03
 **/
// @Component
public class RepeatRequestInterceptor implements HandlerInterceptor {

    @Resource(name = "redisTemplate")
    private RedisTemplate template;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //log.info("可以拦截");
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatRequest repeatReuest = method.getAnnotation(RepeatRequest.class);
            if(null != repeatReuest) {
                if(isRepeat(request)) {
                    //throw new Exception("重复提交");
                } else {
                    return true;
                }
            }
            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 是否与前一次请求重复
     * @param request
     * @return
     */
    private boolean isRepeat(HttpServletRequest request) throws IOException {
        String method = request.getMethod();
        String repeatToken = null;
        if(method.equals("GET")) {
            repeatToken = request.getParameter("repeatToken");
        } else {
            //RequestWrapper requestWrapper = new RequestWrapper(request);
            repeatToken = null;//request.getParameter("repeatToken");
            if(repeatToken == null) {
                String u = request.getCharacterEncoding();
                String body = org.apache.commons.io.IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
                if(StringUtils.isEmpty(body)) {
                    return false;
                }
                JSONObject jsonObject = JSONObject.parseObject(body);
                repeatToken = jsonObject.getString("repeatToken");
                if(null == repeatToken) {
                    String nowData = jsonObject.toJSONString();
                    String uri = request.getRequestURI();
                    Object preData = template.boundValueOps(uri).get();
                    if(preData == null) {
                        template.boundValueOps(uri).set(nowData, 100, TimeUnit.SECONDS);
                        return false;
                    } else {
                        if(nowData.equals(preData)) {
                            return true;
                        } else {
                            template.boundValueOps(uri).set(nowData, 100, TimeUnit.SECONDS);
                            return false;
                        }
                    }
                }
            }

        }

        if(null == repeatToken) {
            return false;
        }
        String uri = request.getRequestURI();
        String nowUrlParams = repeatToken;
        Object preUrlParams = template.boundValueOps(uri).get();//request.getSession().getAttribute("lastRequestData");
        if(null == preUrlParams) {

            template.boundValueOps(uri).set(nowUrlParams, 100, TimeUnit.SECONDS);
            return false;
        } else {
            if(nowUrlParams.equals(preUrlParams)) {
                return true;
            } else {
                template.boundValueOps(uri).set(nowUrlParams, 100, TimeUnit.SECONDS);
                return false;
            }
        }

    }
}
