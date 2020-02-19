package com.coin.auth.controller;

import com.coin.auth.service.SysRoleService;
import com.coin.auth.util.BaseException;
import com.coin.auth.vo.SysRoleVo;
import com.coin.auth.po.SysRolePo;
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
* @ClassName SysRoleCotroller
* @Description: 
* @Author kh
* @Date 2020-02-19
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
     * @date 2020/02/19 09:09:64.050
     */
    @RequestMapping("selectSysRole")
    @ApiOperation(value="查询")
    public Result selectSysRole(SysRoleVo sysRole) throws BaseException {
        return sysRoleService.selectSysRole(sysRole);
    }

    /**
     * @MethodName selectSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:65.050
     */
    @RequestMapping("selectSysRoles")
    @ApiOperation(value="查询")
    public Result selectSysRoles(List<SysRolePo> sysRoleList) throws BaseException {
        return sysRoleService.selectSysRoles(sysRoleList);
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.065
     */
    @RequestMapping("deleteSysRoleById")
    @ApiOperation(value="根据主键删除")
    public Result deleteSysRoleById(SysRoleVo sysRole) throws BaseException {
        return sysRoleService.deleteSysRoleById(sysRole);
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.065
     */
    @RequestMapping("deleteSysRole")
    @ApiOperation(value="删除")
    public Result deleteSysRole(SysRoleVo sysRole) throws BaseException {
        return sysRoleService.deleteSysRole(sysRole);
    }

    /**
    * @MethodName deleteSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:65.050
    */
    @RequestMapping("deleteSysRoles")
    @ApiOperation(value="删除多个")
    public Result deleteSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return sysRoleService.deleteSysRoles(sysRoleList);
    }

    /**
    * @MethodName updateSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:65.050
    */
    @RequestMapping("updateSysRole")
    @ApiOperation(value="更新")
    public Result updateSysRole(SysRoleVo sysRole) throws BaseException {
        return sysRoleService.updateSysRole(sysRole);
    }

    /**
    * @MethodName updateSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:65.050
    */
    @RequestMapping("updateSysRoles")
    @ApiOperation(value="更新多个")
    public Result updateSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return sysRoleService.updateSysRoles(sysRoleList);
    }

    /**
    * @MethodName insertSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:65.050
    */
    @RequestMapping("insertSysRole")
    @ApiOperation(value="插入")
    public Result insertSysRole(SysRoleVo sysRole) throws BaseException {
        return sysRoleService.insertSysRole(sysRole);
    }

    /**
    * @MethodName insertSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:65.050
    */
    @RequestMapping("insertSysRoles")
    @ApiOperation(value="插入多个")
    public Result insertSysRoles(List<SysRoleVo> sysRoleList) throws BaseException  {
        return sysRoleService.insertSysRoles(sysRoleList);
    }

}
