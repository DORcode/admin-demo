package com.coin.auth.controller;

import com.coin.auth.service.SysRolePermissionService;
import com.coin.auth.util.BaseException;
import com.coin.auth.vo.SysRolePermissionVo;
import com.coin.auth.po.SysRolePermissionPo;
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
* @ClassName SysRolePermissionCotroller
* @Description: 角色权限
* @Author kh
* @Date 2020-02-19
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
     * @date 2020/02/19 09:09:107.050
     */
    @RequestMapping("selectSysRolePermission")
    @ApiOperation(value="查询角色权限")
    public Result selectSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return sysRolePermissionService.selectSysRolePermission(sysRolePermission);
    }

    /**
     * @MethodName selectSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:108.050
     */
    @RequestMapping("selectSysRolePermissions")
    @ApiOperation(value="查询角色权限")
    public Result selectSysRolePermissions(List<SysRolePermissionPo> sysRolePermissionList) throws BaseException {
        return sysRolePermissionService.selectSysRolePermissions(sysRolePermissionList);
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.108
     */
    @RequestMapping("deleteSysRolePermissionById")
    @ApiOperation(value="根据主键删除角色权限")
    public Result deleteSysRolePermissionById(SysRolePermissionVo sysRolePermission) throws BaseException {
        return sysRolePermissionService.deleteSysRolePermissionById(sysRolePermission);
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.108
     */
    @RequestMapping("deleteSysRolePermission")
    @ApiOperation(value="删除角色权限")
    public Result deleteSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return sysRolePermissionService.deleteSysRolePermission(sysRolePermission);
    }

    /**
    * @MethodName deleteSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:108.050
    */
    @RequestMapping("deleteSysRolePermissions")
    @ApiOperation(value="删除多个角色权限")
    public Result deleteSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return sysRolePermissionService.deleteSysRolePermissions(sysRolePermissionList);
    }

    /**
    * @MethodName updateSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:108.050
    */
    @RequestMapping("updateSysRolePermission")
    @ApiOperation(value="更新角色权限")
    public Result updateSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return sysRolePermissionService.updateSysRolePermission(sysRolePermission);
    }

    /**
    * @MethodName updateSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:108.050
    */
    @RequestMapping("updateSysRolePermissions")
    @ApiOperation(value="更新多个角色权限")
    public Result updateSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return sysRolePermissionService.updateSysRolePermissions(sysRolePermissionList);
    }

    /**
    * @MethodName insertSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:108.050
    */
    @RequestMapping("insertSysRolePermission")
    @ApiOperation(value="插入角色权限")
    public Result insertSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return sysRolePermissionService.insertSysRolePermission(sysRolePermission);
    }

    /**
    * @MethodName insertSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:108.050
    */
    @RequestMapping("insertSysRolePermissions")
    @ApiOperation(value="插入多个角色权限")
    public Result insertSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException  {
        return sysRolePermissionService.insertSysRolePermissions(sysRolePermissionList);
    }

}
