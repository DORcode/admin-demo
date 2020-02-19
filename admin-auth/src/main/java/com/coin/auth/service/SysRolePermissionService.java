package com.coin.auth.service;

import com.coin.auth.entity.SysRolePermission;
import com.baomidou.mybatisplus.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.po.SysRolePermissionPo;
import com.coin.auth.vo.SysRolePermissionVo;
import java.util.List;

/**
 * @ClassName SysRolePermissionService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-19
 * @Version V1.0
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {

   /**
    * @MethodName selectSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:94.050
    */
   Result selectSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName selectSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:95.050
    */
   Result selectSysRolePermissions(List<SysRolePermissionPo> sysRolePermissionList) throws BaseException;

   /**
   * @MethodName deleteSysRolePermission
   * @Description TODO
   * @param sysRolePermission
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/19 09:09:50.095
   */
   Result deleteSysRolePermissionById(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName deleteSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:50.095
    */
   Result deleteSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName deleteSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:95.050
    */
   Result deleteSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException;

   /**
    * @MethodName updateSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:95.050
    */
   Result updateSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName updateSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:95.050
    */
   Result updateSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException;

   /**
    * @MethodName insertSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:95.050
    */
   Result insertSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName insertSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:95.050
    */
   Result insertSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException;

 }
