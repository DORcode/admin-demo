package com.coin.shiro.config;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @program: demo-parent
 * @description: 保存重复提交拦截,before判断请求的内容在redis中是否存在，存在则报错，return的内容成功就保存请求的参数
 * @author: kh
 * @create: 2018-12-08 14:43:30
 **/
@Aspect
@Component
public class RepeatRequestAspect {
    @Resource(name = "redisTemplate")
    private RedisTemplate template;
    ThreadLocal<String> requestKey = new ThreadLocal<>();
    ThreadLocal<String> requestParam = new ThreadLocal<>();


    @Pointcut("execution(public * com.coin.controller..*.*(..))&& !execution(public * com.coin.controller.StompController.*(..))")
    public void repeatRequest() {
    }

    @Before("repeatRequest() && @annotation(rr)")
    public void before(JoinPoint joinPoint, RepeatRequest rr) throws Exception{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RepeatRequest rrt = method.getAnnotation(RepeatRequest.class);
        if(null == rrt) {
            return;
        }

        Object[] objects = joinPoint.getArgs();
        //String sessionId = getHttpServletRequest().getSession().getId();
        String url = getHttpServletRequest().getRequestURI();
        String userid = "";// AdminShiroUtil.getUserid();
        String key = url;
        if(StringUtils.isNotEmpty(userid)) {
            key += userid;
        }
        String value = null;
        StringBuffer sb = new StringBuffer();
        requestKey.set(key);
        Class<?>[] clss = rr.value();
        for(Object ob : objects) {
            if(isParamClass(clss, ob)) {
                sb.append(JSON.toJSONString(ob));
            }
        }
        String nowParam = sb.toString();
        requestParam.set(nowParam);

        String lastParam = (String) template.boundValueOps(key).get();
        //比较前保存本次
        template.boundValueOps(key).set(nowParam, 10, TimeUnit.SECONDS);
        if(nowParam.equals(lastParam)) {
            throw new Exception("提交内容与上次重复！");
        }
    }

    @AfterReturning(pointcut = "repeatRequest()", returning = "ret")
    public  void afterReturning(JoinPoint joinPoint, Object ret) {
    }

    @AfterThrowing(pointcut = "repeatRequest()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {

    }

    private boolean isParamClass(Class<?>[] clss, Object obj) {
        for(Class<?> cls : clss) {
            String clz = obj.getClass().getName();
            if(clz.equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }
    public HttpServletRequest getHttpServletRequest(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        return request;
    }
}
