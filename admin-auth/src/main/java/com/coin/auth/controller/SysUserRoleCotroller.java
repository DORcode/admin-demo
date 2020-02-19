package com.coin.auth.controller;

import com.coin.auth.service.SysUserRoleService;
import com.coin.auth.util.BaseException;
import com.coin.auth.vo.SysUserRoleVo;
import com.coin.auth.po.SysUserRolePo;
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
* @ClassName SysUserRoleCotroller
* @Description: 用户角色关联表
* @Author kh
* @Date 2020-02-19
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
     * @date 2020/02/19 09:09:193.050
     */
    @RequestMapping("selectSysUserRole")
    @ApiOperation(value="查询用户角色关联表")
    public Result selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return sysUserRoleService.selectSysUserRole(sysUserRole);
    }

    /**
     * @MethodName selectSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:194.050
     */
    @RequestMapping("selectSysUserRoles")
    @ApiOperation(value="查询用户角色关联表")
    public Result selectSysUserRoles(List<SysUserRolePo> sysUserRoleList) throws BaseException {
        return sysUserRoleService.selectSysUserRoles(sysUserRoleList);
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.194
     */
    @RequestMapping("deleteSysUserRoleById")
    @ApiOperation(value="根据主键删除用户角色关联表")
    public Result deleteSysUserRoleById(SysUserRoleVo sysUserRole) throws BaseException {
        return sysUserRoleService.deleteSysUserRoleById(sysUserRole);
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.194
     */
    @RequestMapping("deleteSysUserRole")
    @ApiOperation(value="删除用户角色关联表")
    public Result deleteSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return sysUserRoleService.deleteSysUserRole(sysUserRole);
    }

    /**
    * @MethodName deleteSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:194.050
    */
    @RequestMapping("deleteSysUserRoles")
    @ApiOperation(value="删除多个用户角色关联表")
    public Result deleteSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return sysUserRoleService.deleteSysUserRoles(sysUserRoleList);
    }

    /**
    * @MethodName updateSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:194.050
    */
    @RequestMapping("updateSysUserRole")
    @ApiOperation(value="更新用户角色关联表")
    public Result updateSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return sysUserRoleService.updateSysUserRole(sysUserRole);
    }

    /**
    * @MethodName updateSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:194.050
    */
    @RequestMapping("updateSysUserRoles")
    @ApiOperation(value="更新多个用户角色关联表")
    public Result updateSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return sysUserRoleService.updateSysUserRoles(sysUserRoleList);
    }

    /**
    * @MethodName insertSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:194.050
    */
    @RequestMapping("insertSysUserRole")
    @ApiOperation(value="插入用户角色关联表")
    public Result insertSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return sysUserRoleService.insertSysUserRole(sysUserRole);
    }

    /**
    * @MethodName insertSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:194.050
    */
    @RequestMapping("insertSysUserRoles")
    @ApiOperation(value="插入多个用户角色关联表")
    public Result insertSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException  {
        return sysUserRoleService.insertSysUserRoles(sysUserRoleList);
    }

}
