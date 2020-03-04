package com.coin.auth.web.service;

import com.coin.auth.web.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.po.SysRolePo;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.dto.SysRoleDto;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-27
 * @Version V1.0
 */
public interface SysRoleService extends IService<SysRole> {


   Set<String> selectSysRoleNamesByUserId(String userId);

   /**
    * @MethodName selectSysRoleByUserId
    * @Description TODO
    * @param userId 
    * @return java.util.List<com.coin.auth.web.entity.SysRole>
    * @throws 
    * @author kh
    * @date 2020/2/28 9:50
    */
   List<SysRole> selectSysRoleByUserId(String userId);

   /**
    * @MethodName selectSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:952.014
    */
    SysRoleDto selectSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName selectSysRoles
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:953.014
    */
    List<SysRoleVo> selectSysRoles(SysRolePo sysRole) throws BaseException;

   /**
   * @MethodName deleteSysRole
   * @Description TODO
   * @param sysRole
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/27 07:00:14.953
   */
   int deleteSysRoleById(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName deleteSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:14.953
    */
   int deleteSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName deleteSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:953.014
    */
   int deleteSysRoles(List<SysRoleVo> sysRoleList) throws BaseException;

   /**
    * @MethodName updateSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:953.014
    */
   int updateSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName updateSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:953.014
    */
   int updateSysRoles(List<SysRoleVo> sysRoleList) throws BaseException;

   /**
    * @MethodName insertSysRole
    * @Description TODO
    * @param sysRole
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:953.014
    */
   int insertSysRole(SysRoleVo sysRole) throws BaseException;

   /**
    * @MethodName insertSysRoles
    * @Description TODO
    * @param sysRoleList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:953.014
    */
   int insertSysRoles(List<SysRoleVo> sysRoleList) throws BaseException;

 }
