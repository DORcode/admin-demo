package com.coin.auth.config;

import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.util.ResultCodeEnum;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @program: auth-admin
 * @description:
 * @author: kh
 * @create: 2019-04-16 11:00:23
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public Result exceptionHandler(RuntimeException e, HttpServletResponse response) {
        response.setStatus(401);
        if(e instanceof BaseException) {
            return Result.fail((BaseException) e);
        } else if(e instanceof AccountException) {
            return Result.fail(ResultCodeEnum.ACCOUNT_ERROR);
        } else {
            return Result.fail(ResultCodeEnum.SERVER_ERROR);
        }

    }
}
