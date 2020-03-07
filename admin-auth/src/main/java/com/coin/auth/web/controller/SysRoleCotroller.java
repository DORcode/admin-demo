package com.coin.auth.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.dto.SysRoleDto;
import com.coin.auth.web.entity.SysRole;
import com.coin.auth.web.service.SysRoleService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.po.SysRolePo;
import com.coin.auth.util.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysRoleCotroller
* @Description: 
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/

@Slf4j
@RestController
@RequestMapping("/api/sysrole")
@Api(tags="")
public class SysRoleCotroller {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * @MethodName selectSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:960.014
     */
    @RequestMapping("selectSysRole")
    @ApiOperation(value="查询")
    public Result selectSysRole(SysRoleVo sysRole) throws BaseException {
        SysRoleDto sysRoleDto = sysRoleService.selectSysRole(sysRole);
        return Result.success(sysRoleDto);
    }

    /**
     * @MethodName selectSysRoles
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:960.014
     */
    @RequestMapping("selectSysRoles")
    @ApiOperation(value="查询")
    public Result selectSysRoles(SysRolePo sysRole) throws BaseException {
        IPage<SysRole> roleIPage = sysRoleService.selectSysRoles(sysRole);
        return Result.success(roleIPage);
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:14.960
     */
    @RequestMapping("deleteSysRoleById")
    @ApiOperation(value="根据主键删除")
    public Result deleteSysRoleById(SysRoleVo sysRole) throws BaseException {
        sysRoleService.deleteSysRoleById(sysRole);
        return Result.success(ResultCodeEnum.DELETE_SUCCESS);
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:14.960
     */
    @RequiresPermissions(value = "delete")
    @RequestMapping("deleteSysRole")
    @ApiOperation(value="删除")
    public Result deleteSysRole(SysRoleVo sysRole) throws BaseException {
        sysRoleService.deleteSysRole(sysRole);
        return Result.success(ResultCodeEnum.DELETE_SUCCESS);
    }

    /**
    * @MethodName deleteSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:960.014
    */
    @RequestMapping("deleteSysRoles")
    @ApiOperation(value="删除多个")
    public Result deleteSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        sysRoleService.deleteSysRoles(sysRoleList);
        return Result.success(ResultCodeEnum.DELETE_SUCCESS);
    }

    /**
    * @MethodName updateSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:960.014
    */
    @RequestMapping("updateSysRole")
    @ApiOperation(value="更新")
    public Result updateSysRole(SysRoleVo sysRole) throws BaseException {
        sysRoleService.updateSysRole(sysRole);
        return Result.success(ResultCodeEnum.UPDATE_SUCCESS);
    }

    /**
    * @MethodName updateSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:961.014
    */
    @RequestMapping("updateSysRoles")
    @ApiOperation(value="更新多个")
    public Result updateSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        sysRoleService.updateSysRoles(sysRoleList);
        return Result.success(ResultCodeEnum.UPDATE_SUCCESS);
    }

    /**
    * @MethodName insertSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:961.014
    */
    @RequestMapping("insertSysRole")
    @ApiOperation(value="插入")
    public Result insertSysRole(SysRoleVo sysRole) throws BaseException {
        sysRoleService.insertSysRole(sysRole);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

    /**
    * @MethodName insertSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:961.014
    */
    @RequestMapping("insertSysRoles")
    @ApiOperation(value="插入多个")
    public Result insertSysRoles(List<SysRoleVo> sysRoleList) throws BaseException  {
        sysRoleService.insertSysRoles(sysRoleList);
        return Result.success(ResultCodeEnum.SAVE_SUCCESS);
    }

}
