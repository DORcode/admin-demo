package com.coin.auth.service;

import com.coin.auth.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.po.SysRolePo;
import com.coin.auth.vo.SysRoleVo;
import java.util.List;

/**
 * @ClassName SysRoleService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-19
 * @Version V1.0
 */
public interface SysRoleService extends IService<SysRole> {

   /**
    * @MethodName selectSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result selectSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName selectSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result selectSysRoles(List<SysRolePo> sysRoleList) throws BaseException;

   /**
   * @MethodName deleteSysRole
   * @Description TODO
   * @param sysRole
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/19 09:09:50.054
   */
   Result deleteSysRoleById(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName deleteSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:50.054
    */
   Result deleteSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName deleteSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result deleteSysRoles(List<SysRoleVo> sysRoleList) throws BaseException;

   /**
    * @MethodName updateSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result updateSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName updateSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result updateSysRoles(List<SysRoleVo> sysRoleList) throws BaseException;

   /**
    * @MethodName insertSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result insertSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName insertSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:54.050
    */
   Result insertSysRoles(List<SysRoleVo> sysRoleList) throws BaseException;

 }
