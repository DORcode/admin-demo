package com.coin.auth.web.service;

import com.coin.auth.web.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.po.SysUserRolePo;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.vo.SysUserRoleVo;
import com.coin.auth.web.dto.SysUserRoleDto;
import java.util.List;

/**
 * @ClassName SysUserRoleService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-27
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
    * @date 2020/02/27 07:00:89.015
    */
    SysRoleVo selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName selectSysUserRoles
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:89.015
    */
    List<SysRoleVo> selectSysUserRoles(SysUserRolePo sysUserRole) throws BaseException;

   /**
   * @MethodName deleteSysUserRole
   * @Description TODO
   * @param sysUserRole
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/27 07:00:15.089
   */
   int deleteSysUserRoleById(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName deleteSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:15.089
    */
   int deleteSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName deleteSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:90.015
    */
   int deleteSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException;

   /**
    * @MethodName updateSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:90.015
    */
   int updateSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName updateSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:90.015
    */
   int updateSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException;

   /**
    * @MethodName insertSysUserRole
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:90.015
    */
   int insertSysUserRole(SysUserRoleVo sysUserRole) throws BaseException;

   /**
    * @MethodName insertSysUserRoles
    * @Description TODO
    * @param sysUserRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:90.015
    */
   int insertSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException;

 }
