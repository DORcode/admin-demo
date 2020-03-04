package com.coin.auth.web.controller;

import com.coin.auth.web.service.SysRoleService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.po.SysRolePo;
import com.coin.auth.util.Result;
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
        sysRoleService.selectSysRole(sysRole);
        return Result.success();
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
        sysRoleService.selectSysRoles(sysRole);
        return Result.success();
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
        return Result.success();
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
    @RequestMapping("deleteSysRole")
    @ApiOperation(value="删除")
    public Result deleteSysRole(SysRoleVo sysRole) throws BaseException {
        sysRoleService.deleteSysRole(sysRole);
        return Result.success();
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
        return Result.success();
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
        return Result.success();
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
        return Result.success();
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
        return Result.success();
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
        return Result.success();
    }

}
