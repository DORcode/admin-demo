package com.coin.auth.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.service.SysRolePermissionService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.vo.SysRolePermissionVo;
import com.coin.auth.web.po.SysRolePermissionPo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysRolePermissionCotroller
* @Description: 角色权限关联管理
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/

@Slf4j
@RestController
@RequestMapping("/api/sysrolepermission")
@Api(tags="角色权限")
public class SysRolePermissionCotroller {

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    /**
     * @MethodName selectSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:06.015
     */
    @RequestMapping("selectSysRolePermission")
    @ApiOperation(value="查询角色权限")
    public Result selectSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        sysRolePermissionService.selectSysRolePermission(sysRolePermission);
        return Result.success();
    }

    /**
     * @MethodName selectSysRolePermissions
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:07.015
     */
    @RequestMapping("selectSysRolePermissions")
    @ApiOperation(value="查询角色权限")
    public Result selectSysRolePermissions(Page page, SysPermissionPo sysPermission) throws BaseException {
        IPage<SysPermissionVo> permissions = sysRolePermissionService.selectSysRolePermissions(page, sysPermission);
        return Result.success(permissions);
    }

    /**
     * @MethodName selectSysRolePermissions
     * @Description TODO
     * @param roleId
     * @return com.coin.auth.util.Result
     * @throws
     * @author kh
     * @date 2020/4/4 21:21
     */
    @RequestMapping("selectSysRolePermissions/{roleId}")
    @ApiOperation(value="查询权限树形")
    public Result selectSysRolePermissions(@PathVariable("roleId") String roleId) throws BaseException {
        List<SysPermissionVo> perms = sysRolePermissionService.selectSysRolePermissions(roleId);
        return Result.success(perms);
    }

    @RequestMapping("deleteSysRolePermission/{roleId}")
    @ApiOperation(value="删除角色权限")
    public Result deleteSysRolePermission(@PathVariable("roleId") String roleId) throws BaseException {
        int i = sysRolePermissionService.deleteByRoleId(roleId);
        return Result.success(ResultCodeEnum.DELETE_SUCCESS);
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:15.007
     */
    @RequestMapping("deleteSysRolePermissionById")
    @ApiOperation(value="根据主键删除角色权限")
    public Result deleteSysRolePermissionById(SysRolePermissionVo sysRolePermission) throws BaseException {
        sysRolePermissionService.deleteSysRolePermissionById(sysRolePermission);
        return Result.success();
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:15.007
     */
    @RequestMapping("deleteSysRolePermission")
    @ApiOperation(value="删除角色权限")
    public Result deleteSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        sysRolePermissionService.deleteSysRolePermission(sysRolePermission);
        return Result.success();
    }

    /**
    * @MethodName deleteSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:07.015
    */
    @RequestMapping("deleteSysRolePermissions")
    @ApiOperation(value="删除多个角色权限")
    public Result deleteSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        sysRolePermissionService.deleteSysRolePermissions(sysRolePermissionList);
        return Result.success();
    }

    /**
    * @MethodName updateSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:07.015
    */
    @RequestMapping("updateSysRolePermission")
    @ApiOperation(value="更新角色权限")
    public Result updateSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        sysRolePermissionService.updateSysRolePermission(sysRolePermission);
        return Result.success();
    }

    /**
    * @MethodName updateSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:07.015
    */
    @RequestMapping("updateSysRolePermissions")
    @ApiOperation(value="更新多个角色权限")
    public Result updateSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        sysRolePermissionService.updateSysRolePermissions(sysRolePermissionList);
        return Result.success();
    }

    /**
    * @MethodName insertSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:07.015
    */
    @RequestMapping("insertSysRolePermission")
    @ApiOperation(value="插入角色权限")
    public Result insertSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        sysRolePermissionService.insertSysRolePermission(sysRolePermission);
        return Result.success();
    }

    /**
    * @MethodName insertSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:07.015
    */
    @RequestMapping("insertSysRolePermissions")
    @ApiOperation(value="插入多个角色权限")
    public Result insertSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException  {
        sysRolePermissionService.insertSysRolePermissions(sysRolePermissionList);
        return Result.success();
    }

}
