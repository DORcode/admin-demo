package com.coin.auth.web.controller;

import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.service.SysPermissionService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.Menu;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysPermissionCotroller
* @Description: 权限
* @Author kh
* @Date 2020-02-27
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
     * @date 2020/02/27 07:00:927.014
     */
    @PostMapping("selectSysPermission")
    @ApiOperation(value="查询权限")
    public Result selectSysPermission(SysPermissionVo sysPermission) throws BaseException {
        sysPermissionService.selectSysPermission(sysPermission);
        return Result.success();
    }
    
    /**
     * @MethodName menus
     * @Description 菜单
     * @param  
     * @return com.coin.auth.util.Result
     * @throws 
     * @author kh
     * @date 2020/3/9 20:14
     */
    @RequestMapping("menus")
    @ApiOperation(value="菜单树形")
    public Result menus() {
        List<Menu> menus = sysPermissionService.selectMenuList();
        return Result.success(menus);
    }

    @RequestMapping("selectPermissionList")
    @ApiOperation(value="查询权限列表")
    public Result selectPermissionList()  throws BaseException {
        List<SysPermissionVo> sysPermissionVos = sysPermissionService.selectPermissionList();
        return Result.success(sysPermissionVos);
    }

    /**
     * @MethodName selectSysPermissions
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:927.014
     */
    @RequestMapping("selectSysPermissions")
    @ApiOperation(value="查询权限")
    public Result selectSysPermissions(SysPermissionPo sysPermission) throws BaseException {
        sysPermissionService.selectSysPermissions(sysPermission);
        return Result.success();
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:14.927
     */
    @RequestMapping("deleteSysPermissionById")
    @ApiOperation(value="根据主键删除权限")
    public Result deleteSysPermissionById(SysPermissionVo sysPermission) throws BaseException {
        sysPermissionService.deleteSysPermissionById(sysPermission);
        return Result.success(ResultCodeEnum.DELETE_SUCCESS);
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:14.927
     */
    @RequestMapping("deleteSysPermission")
    @ApiOperation(value="删除权限")
    public Result deleteSysPermission(SysPermissionVo sysPermission) throws BaseException {
        sysPermissionService.deleteSysPermission(sysPermission);
        return Result.success(ResultCodeEnum.DELETE_SUCCESS);
    }

    /**
    * @MethodName deleteSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:927.014
    */
    @RequestMapping("deleteSysPermissions")
    @ApiOperation(value="删除多个权限")
    public Result deleteSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        sysPermissionService.deleteSysPermissions(sysPermissionList);
        return Result.success();
    }

    /**
    * @MethodName updateSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:927.014
    */
    @RequestMapping("updateSysPermission")
    @ApiOperation(value="更新权限")
    public Result updateSysPermission(SysPermissionVo sysPermission) throws BaseException {
        sysPermissionService.updateSysPermission(sysPermission);
        return Result.success(ResultCodeEnum.UPDATE_SUCCESS);
    }

    /**
    * @MethodName updateSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:927.014
    */
    @RequestMapping("updateSysPermissions")
    @ApiOperation(value="更新多个权限")
    public Result updateSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        sysPermissionService.updateSysPermissions(sysPermissionList);
        return Result.success(ResultCodeEnum.UPDATE_SUCCESS);
    }

    /**
    * @MethodName insertSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:927.014
    */
    @RequestMapping("insertSysPermission")
    @ApiOperation(value="插入权限")
    public Result insertSysPermission(SysPermissionVo sysPermission) throws BaseException {
        sysPermissionService.insertSysPermission(sysPermission);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

    /**
    * @MethodName insertSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:927.014
    */
    @RequestMapping("insertSysPermissions")
    @ApiOperation(value="插入多个权限")
    public Result insertSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException  {
        sysPermissionService.insertSysPermissions(sysPermissionList);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

}
