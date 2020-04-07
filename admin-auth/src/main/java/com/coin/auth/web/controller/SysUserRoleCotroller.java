package com.coin.auth.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.service.SysUserRoleService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.vo.SysUserRoleVo;
import com.coin.auth.web.po.SysUserRolePo;
import com.coin.auth.util.Result;
import com.coin.auth.web.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Result selectSysUserRole(@RequestBody SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.selectSysUserRole(sysUserRole);
        // 用户 角色，用户绑定角色，

        // 用户添加角色 用户id， 角色id即可
        // 用户修改角色?需要修改吗？那么需要保证唯一关联性
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
    public Result selectSysUserRoles(@RequestBody SysUserRolePo sysUserRole) throws BaseException {
        List<SysRoleVo> sysRoleVos = sysUserRoleService.selectSysUserRoles(sysUserRole);
        return Result.success(sysRoleVos);
    }

    @RequestMapping("selectRelatedSysUsers")
    @ApiOperation(value="查询角色已关联的用户")
    public Result selectelatedSysUsers(@RequestBody SysUserRolePo sysUserRole) throws BaseException {
        IPage<SysUserVo> pages = sysUserRoleService.selectRlatedSysUsers(new Page(sysUserRole.getCurrent(), sysUserRole.getSize()), sysUserRole);
        return Result.success(pages);
    }

    @RequestMapping("selectUnrelatedSysUsers")
    @ApiOperation(value="查询角色未关联的用户")
    public Result selectUnrelatedSysUsers(@RequestBody SysUserRolePo sysUserRole) throws BaseException {
        IPage<SysUserVo> pages = sysUserRoleService.selectUnrelatedSysUsers(new Page(sysUserRole.getCurrent(), sysUserRole.getSize()), sysUserRole);
        return Result.success(pages);
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
    public Result deleteSysUserRoleById(@RequestBody SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.deleteSysUserRoleById(sysUserRole);
        return Result.success(ResultCodeEnum.UPDATE_SUCCESS);
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
    public Result deleteSysUserRole(@RequestBody SysUserRoleVo sysUserRole) throws BaseException {
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
    public Result deleteSysUserRoles(@RequestBody List<SysUserRoleVo> sysUserRoleList) throws BaseException {
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
    public Result updateSysUserRole(@RequestBody SysUserRoleVo sysUserRole) throws BaseException {
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
    public Result updateSysUserRoles(@RequestBody List<SysUserRoleVo> sysUserRoleList) throws BaseException {
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
    public Result insertSysUserRole(@RequestBody SysUserRoleVo sysUserRole) throws BaseException {
        sysUserRoleService.insertSysUserRole(sysUserRole);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
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
    public Result insertSysUserRoles(@RequestBody List<SysUserRoleVo> sysUserRoleList) throws BaseException  {
        sysUserRoleService.insertSysUserRoles(sysUserRoleList);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

}
