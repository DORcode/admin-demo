package com.coin.auth.web.controller;


import com.coin.auth.config.YmlConfig;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.service.SysUserService;
import com.coin.auth.util.Result;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AuthController
 * @Description: 认证操作
 * @Author kh
 * @Date 2020-02-19
 * @Version V1.0
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
@Api(tags="登录认证")
public class AuthController {
    @Autowired
    YmlConfig jwtConfig;

    @Autowired
    private SysUserService sysUserService;

    /**
     * @MethodName login
     * @Description 登录验证
     * @param sysUser 用户
     * @return com.coin.auth.util.Result
     * @throws
     * @author kh
     * @date 2020/2/26 16:46
     */
    @ApiOperation(value = "登录验证")
    @RequestMapping("login")
    @ResponseBody
    public Result login(@RequestBody SysUser sysUser) {
        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
        try {
            currentUser.login(token);
            SysUser user = (SysUser) currentUser.getPrincipal();
            Map map = jwtConfig.createJwtMap(user.getId(), user.getName());
            // 生成token
            return Result.success(ResultCodeEnum.LOGIN_SUCCESS, map);
        } catch ( AuthenticationException e) {
            return Result.fail(ResultCodeEnum.ACCOUNT_ERROR);
        }

    }

    /**
     * @MethodName logout
     * @Description 退出登录
     * @param
     * @return com.coin.auth.util.Result
     * @throws
     * @author kh
     * @date 2020/2/26 16:46
     */
    @ApiOperation(value = "退出")
    @RequestMapping("logout")
    @ResponseBody
    public Result logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return Result.success(ResultCodeEnum.LOGINOUT_SUCCESS);
    }

    @ApiOperation(value = "注册")
    @RequestMapping(value = "logon", method = RequestMethod.POST)
    @ResponseBody
    public Result logon(SysUserVo user) throws BaseException {
        int num = sysUserService.insertSysUser(user);
        return Result.success(ResultCodeEnum.LOGON_SUCCESS);
    }


}
