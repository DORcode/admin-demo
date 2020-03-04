package com.coin.auth.web.controller;

import com.coin.auth.web.service.SysUserRoleService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysUserRoleVo;
import com.coin.auth.web.po.SysUserRolePo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysUserRoleCotroller
* @Description: 用户角色关联表
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/

@Slf4j
@RestController
@RequestMapping("/api/sysuserrole")
@Api(tags="用户角色关联表")
public class SysUserRoleCotroller {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * @MethodName selectSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:105.015
     */
    @RequestMapping("selectSysUserRole")
    @ApiOperation(value="查询用户角色关联表")
    public Result selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.selectSysUserRole(sysUserRole);
        return Result.success();
    }

    /**
     * @MethodName selectSysUserRoles
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:105.015
     */
    @RequestMapping("selectSysUserRoles")
    @ApiOperation(value="查询用户角色关联表")
    public Result selectSysUserRoles(SysUserRolePo sysUserRole) throws BaseException {
        sysUserRoleService.selectSysUserRoles(sysUserRole);
        return Result.success();
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:15.105
     */
    @RequestMapping("deleteSysUserRoleById")
    @ApiOperation(value="根据主键删除用户角色关联表")
    public Result deleteSysUserRoleById(SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.deleteSysUserRoleById(sysUserRole);
        return Result.success();
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:15.106
     */
    @RequestMapping("deleteSysUserRole")
    @ApiOperation(value="删除用户角色关联表")
    public Result deleteSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.deleteSysUserRole(sysUserRole);
        return Result.success();
    }

    /**
    * @MethodName deleteSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:106.015
    */
    @RequestMapping("deleteSysUserRoles")
    @ApiOperation(value="删除多个用户角色关联表")
    public Result deleteSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        sysUserRoleService.deleteSysUserRoles(sysUserRoleList);
        return Result.success();
    }

    /**
    * @MethodName updateSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:106.015
    */
    @RequestMapping("updateSysUserRole")
    @ApiOperation(value="更新用户角色关联表")
    public Result updateSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.updateSysUserRole(sysUserRole);
        return Result.success();
    }

    /**
    * @MethodName updateSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:106.015
    */
    @RequestMapping("updateSysUserRoles")
    @ApiOperation(value="更新多个用户角色关联表")
    public Result updateSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        sysUserRoleService.updateSysUserRoles(sysUserRoleList);
        return Result.success();
    }

    /**
    * @MethodName insertSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:106.015
    */
    @RequestMapping("insertSysUserRole")
    @ApiOperation(value="插入用户角色关联表")
    public Result insertSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.insertSysUserRole(sysUserRole);
        return Result.success();
    }

    /**
    * @MethodName insertSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:106.015
    */
    @RequestMapping("insertSysUserRoles")
    @ApiOperation(value="插入多个用户角色关联表")
    public Result insertSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException  {
        sysUserRoleService.insertSysUserRoles(sysUserRoleList);
        return Result.success();
    }

}
