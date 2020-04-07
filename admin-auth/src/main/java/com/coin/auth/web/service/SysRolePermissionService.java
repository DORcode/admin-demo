package com.coin.auth.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.web.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.po.SysRolePermissionPo;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.vo.SysRolePermissionVo;
import com.coin.auth.web.dto.SysRolePermissionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysRolePermissionService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-27
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
    * @date 2020/02/27 07:00:996.014
    */
    SysRolePermissionDto selectSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName selectSysRolePermissions
    * @Description TODO
    * @param 
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:996.014
    */
   IPage<SysPermissionVo> selectSysRolePermissions(Page page, SysPermissionPo sysPermission) throws BaseException;
   
   /**
    * @MethodName selectSysRolePermissions
    * @Description TODO
    * @param roleId 
    * @return java.util.List<com.coin.auth.web.vo.SysPermissionVo>
    * @throws 
    * @author kh
    * @date 2020/4/4 12:19
    */
   List<SysPermissionVo> selectSysRolePermissions(String roleId) throws BaseException;
   /**
   * @MethodName deleteSysRolePermission
   * @Description TODO
   * @param sysRolePermission
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/27 07:00:14.996
   */
   int deleteSysRolePermissionById(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName deleteSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:14.996
    */
   int deleteSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName deleteSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:996.014
    */
   int deleteSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException;

   /**
    * @MethodName deleteByRoleId
    * @Description TODO
    * @param roleId
    * @return int
    * @throws
    * @author kh
    * @date 2020/4/4 11:32
    */
   int deleteByRoleId(@Param("roleId") String roleId) throws BaseException;
   /**
    * @MethodName updateSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:996.014
    */
   int updateSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName updateSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:996.014
    */
   int updateSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException;

   /**
    * @MethodName insertSysRolePermission
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:996.014
    */
   int insertSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException;

   /**
    * @MethodName insertSysRolePermissions
    * @Description TODO
    * @param sysRolePermissionList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:996.014
    */
   int insertSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException;

 }
