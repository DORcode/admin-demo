package com.coin.auth.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coin.auth.util.BeanUtil;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.service.SysUserService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysUserVo;
import com.coin.auth.web.po.SysUserPo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysUserCotroller
* @Description: 用户
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/

@Slf4j
@RestController
@RequestMapping("/api/sysuser")
@Api(tags="用户")
public class SysUserCotroller {

    @Autowired
    private SysUserService sysUserService;

    /**
     * @MethodName selectSysUser
     * @Description 此处有问题，入参和返回都不合理
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:54.015
     */
    @RequestMapping("selectSysUser")
    @ApiOperation(value="查询用户")
    public Result selectSysUser(@RequestBody SysUserVo sysUser) throws BaseException {
        SysUser user = new SysUser();
        BeanUtil.copyProperties(user, sysUser);
        SysUser u = sysUserService.selectOneSelective(user);
        return Result.success(u);
    }

    /**
     * @MethodName selectSysUsers
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:54.015
     */
    @RequestMapping("selectSysUsers")
    @ApiOperation(value="查询用户")
    public Result selectSysUsers(@RequestBody SysUserPo sysUser) throws BaseException {
        IPage<SysUser> userIPage = sysUserService.selectSysUsers(sysUser);
        return Result.success(userIPage);
    }

    /**
     * @MethodName deleteSysUser
     * @Description 改成restful
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:15.054
     */
    @RequestMapping("deleteSysUserById")
    @ApiOperation(value="根据主键删除用户")
    public Result deleteSysUserById(@RequestBody SysUserVo sysUser) throws BaseException {
        int num = sysUserService.deleteSysUser(sysUser);
        if(num == 1) {
            return Result.success(ResultCodeEnum.SAVE_SUCCESS);
        } else {
            throw new BaseException(ResultCodeEnum.SAVE_FAIL);
        }


    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:15.054
     */
    @RequestMapping("deleteSysUser")
    @ApiOperation(value="删除用户")
    public Result deleteSysUser(@RequestBody SysUserVo sysUser) throws BaseException {
        sysUserService.deleteSysUser(sysUser);
        return Result.success();
    }

    /**
    * @MethodName deleteSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:55.015
    */
    @RequestMapping("deleteSysUsers")
    @ApiOperation(value="删除多个用户")
    public Result deleteSysUsers(@RequestBody List<SysUserVo> sysUserList) throws BaseException {
        sysUserService.deleteSysUsers(sysUserList);
        return Result.success();
    }

    /**
    * @MethodName updateSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:55.015
    */
    @RequestMapping("updateSysUser")
    @ApiOperation(value="更新用户")
    public Result updateSysUser(@RequestBody SysUserVo sysUser) throws BaseException {
        sysUserService.updateSysUser(sysUser);
        return Result.success();
    }

    /**
    * @MethodName updateSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:55.015
    */
    @RequestMapping("updateSysUsers")
    @ApiOperation(value="更新多个用户")
    public Result updateSysUsers(@RequestBody List<SysUserVo> sysUserList) throws BaseException {
        sysUserService.updateSysUsers(sysUserList);
        return Result.success();
    }

    /**
    * @MethodName insertSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:55.015
    */
    @RequestMapping("insertSysUser")
    @ApiOperation(value="插入用户")
    public Result insertSysUser(@RequestBody SysUserVo sysUser) throws BaseException {
        sysUserService.insertSysUser(sysUser);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

    /**
    * @MethodName insertSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:55.015
    */
    @RequestMapping("insertSysUsers")
    @ApiOperation(value="插入多个用户")
    public Result insertSysUsers(@RequestBody List<SysUserVo> sysUserList) throws BaseException  {
        sysUserService.insertSysUsers(sysUserList);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

}
