package com.coin.auth.service;

import com.coin.auth.entity.SysUserRole;
import com.baomidou.mybatisplus.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.po.SysUserRolePo;
import com.coin.auth.vo.SysUserRoleVo;
import java.util.List;

/**
 * @ClassName SysUserRoleService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-19
 * @Version V1.0
 */
public interface SysUserRoleService extends IService<SysUserRole> {

   /**
    * @MethodName selectSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:181.050
    */
   Result selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName selectSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:181.050
    */
   Result selectSysUserRoles(List<SysUserRolePo> sysUserRoleList) throws BaseException;

   /**
   * @MethodName deleteSysUserRole
   * @Description TODO
   * @param sysUserRole
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/19 09:09:50.182
   */
   Result deleteSysUserRoleById(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName deleteSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:50.182
    */
   Result deleteSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName deleteSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:182.050
    */
   Result deleteSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException;

   /**
    * @MethodName updateSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:182.050
    */
   Result updateSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName updateSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:182.050
    */
   Result updateSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException;

   /**
    * @MethodName insertSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:182.050
    */
   Result insertSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName insertSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:182.050
    */
   Result insertSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException;

 }
