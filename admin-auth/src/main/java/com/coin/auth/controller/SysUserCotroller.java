package com.coin.auth.controller;

import com.coin.auth.service.SysUserService;
import com.coin.auth.util.BaseException;
import com.coin.auth.vo.SysUserVo;
import com.coin.auth.po.SysUserPo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysUserCotroller
* @Description: 用户
* @Author kh
* @Date 2020-02-19
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
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:152.050
     */
    @RequestMapping("selectSysUser")
    @ApiOperation(value="查询用户")
    public Result selectSysUser(SysUserVo sysUser) throws BaseException {
        return sysUserService.selectSysUser(sysUser);
    }

    /**
     * @MethodName selectSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:152.050
     */
    @RequestMapping("selectSysUsers")
    @ApiOperation(value="查询用户")
    public Result selectSysUsers(List<SysUserPo> sysUserList) throws BaseException {
        return sysUserService.selectSysUsers(sysUserList);
    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.153
     */
    @RequestMapping("deleteSysUserById")
    @ApiOperation(value="根据主键删除用户")
    public Result deleteSysUserById(SysUserVo sysUser) throws BaseException {
        return sysUserService.deleteSysUserById(sysUser);
    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.153
     */
    @RequestMapping("deleteSysUser")
    @ApiOperation(value="删除用户")
    public Result deleteSysUser(SysUserVo sysUser) throws BaseException {
        return sysUserService.deleteSysUser(sysUser);
    }

    /**
    * @MethodName deleteSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:153.050
    */
    @RequestMapping("deleteSysUsers")
    @ApiOperation(value="删除多个用户")
    public Result deleteSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return sysUserService.deleteSysUsers(sysUserList);
    }

    /**
    * @MethodName updateSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:153.050
    */
    @RequestMapping("updateSysUser")
    @ApiOperation(value="更新用户")
    public Result updateSysUser(SysUserVo sysUser) throws BaseException {
        return sysUserService.updateSysUser(sysUser);
    }

    /**
    * @MethodName updateSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:153.050
    */
    @RequestMapping("updateSysUsers")
    @ApiOperation(value="更新多个用户")
    public Result updateSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return sysUserService.updateSysUsers(sysUserList);
    }

    /**
    * @MethodName insertSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:153.050
    */
    @RequestMapping("insertSysUser")
    @ApiOperation(value="插入用户")
    public Result insertSysUser(SysUserVo sysUser) throws BaseException {
        return sysUserService.insertSysUser(sysUser);
    }

    /**
    * @MethodName insertSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:153.050
    */
    @RequestMapping("insertSysUsers")
    @ApiOperation(value="插入多个用户")
    public Result insertSysUsers(List<SysUserVo> sysUserList) throws BaseException  {
        return sysUserService.insertSysUsers(sysUserList);
    }

}
