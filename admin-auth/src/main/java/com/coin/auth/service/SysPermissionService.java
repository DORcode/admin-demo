package com.coin.auth.service;

import com.coin.auth.entity.SysPermission;
import com.baomidou.mybatisplus.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.po.SysPermissionPo;
import com.coin.auth.vo.SysPermissionVo;
import java.util.List;

/**
 * @ClassName SysPermissionService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-19
 * @Version V1.0
 */
public interface SysPermissionService extends IService<SysPermission> {

   /**
    * @MethodName selectSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result selectSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName selectSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result selectSysPermissions(List<SysPermissionPo> sysPermissionList) throws BaseException;

   /**
   * @MethodName deleteSysPermission
   * @Description TODO
   * @param sysPermission
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/19 09:09:50.021
   */
   Result deleteSysPermissionById(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName deleteSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:50.021
    */
   Result deleteSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName deleteSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result deleteSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException;

   /**
    * @MethodName updateSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result updateSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName updateSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result updateSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException;

   /**
    * @MethodName insertSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result insertSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName insertSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:21.050
    */
   Result insertSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException;

 }
