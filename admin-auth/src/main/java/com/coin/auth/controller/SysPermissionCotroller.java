package com.coin.auth.controller;

import com.coin.auth.service.SysPermissionService;
import com.coin.auth.util.BaseException;
import com.coin.auth.vo.SysPermissionVo;
import com.coin.auth.po.SysPermissionPo;
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
* @ClassName SysPermissionCotroller
* @Description: 权限
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/

@Slf4j
@RestController
@RequestMapping("/api/syspermission")
@Api(tags="权限")
public class SysPermissionCotroller {

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * @MethodName selectSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:29.050
     */
    @RequestMapping("selectSysPermission")
    @ApiOperation(value="查询权限")
    public Result selectSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return sysPermissionService.selectSysPermission(sysPermission);
    }

    /**
     * @MethodName selectSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:30.050
     */
    @RequestMapping("selectSysPermissions")
    @ApiOperation(value="查询权限")
    public Result selectSysPermissions(List<SysPermissionPo> sysPermissionList) throws BaseException {
        return sysPermissionService.selectSysPermissions(sysPermissionList);
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.030
     */
    @RequestMapping("deleteSysPermissionById")
    @ApiOperation(value="根据主键删除权限")
    public Result deleteSysPermissionById(SysPermissionVo sysPermission) throws BaseException {
        return sysPermissionService.deleteSysPermissionById(sysPermission);
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.030
     */
    @RequestMapping("deleteSysPermission")
    @ApiOperation(value="删除权限")
    public Result deleteSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return sysPermissionService.deleteSysPermission(sysPermission);
    }

    /**
    * @MethodName deleteSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:30.050
    */
    @RequestMapping("deleteSysPermissions")
    @ApiOperation(value="删除多个权限")
    public Result deleteSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        return sysPermissionService.deleteSysPermissions(sysPermissionList);
    }

    /**
    * @MethodName updateSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:30.050
    */
    @RequestMapping("updateSysPermission")
    @ApiOperation(value="更新权限")
    public Result updateSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return sysPermissionService.updateSysPermission(sysPermission);
    }

    /**
    * @MethodName updateSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:30.050
    */
    @RequestMapping("updateSysPermissions")
    @ApiOperation(value="更新多个权限")
    public Result updateSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        return sysPermissionService.updateSysPermissions(sysPermissionList);
    }

    /**
    * @MethodName insertSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:30.050
    */
    @RequestMapping("insertSysPermission")
    @ApiOperation(value="插入权限")
    public Result insertSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return sysPermissionService.insertSysPermission(sysPermission);
    }

    /**
    * @MethodName insertSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:31.050
    */
    @RequestMapping("insertSysPermissions")
    @ApiOperation(value="插入多个权限")
    public Result insertSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException  {
        return sysPermissionService.insertSysPermissions(sysPermissionList);
    }

}
