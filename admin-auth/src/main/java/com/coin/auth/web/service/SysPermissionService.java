package com.coin.auth.web.service;

import com.coin.auth.web.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.dto.SysPermissionDto;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysPermissionService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-27
 * @Version V1.0
 */
public interface SysPermissionService extends IService<SysPermission> {

   /**
    * @MethodName selectPermissionsByUserId
    * @Description TODO
    * @param userId
    * @return java.util.Set<java.lang.String>
    * @throws
    * @author kh
    * @date 2020/2/28 10:16
    */
   Set<String> selectPermissionsByUserId(String userId);

   /**
    * @MethodName selectSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:913.014
    */
    SysPermissionDto selectSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName selectSysPermissions
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:913.014
    */
    List<SysPermissionVo> selectSysPermissions(SysPermissionPo sysPermission) throws BaseException;

   /**
   * @MethodName deleteSysPermission
   * @Description TODO
   * @param sysPermission
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/27 07:00:14.914
   */
   int deleteSysPermissionById(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName deleteSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:14.914
    */
   int deleteSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName deleteSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:914.014
    */
   int deleteSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException;

   /**
    * @MethodName updateSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:914.014
    */
   int updateSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName updateSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:914.014
    */
   int updateSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException;

   /**
    * @MethodName insertSysPermission
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:914.014
    */
   int insertSysPermission(SysPermissionVo sysPermission) throws BaseException;

   /**
    * @MethodName insertSysPermissions
    * @Description TODO
    * @param sysPermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:914.014
    */
   int insertSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException;

 }
