package com.coin.auth.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coin.auth.web.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.po.SysUserPo;
import com.coin.auth.web.vo.SysUserVo;
import com.coin.auth.web.dto.SysUserDto;
import java.util.List;

/**
 * @ClassName SysUserService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-27
 * @Version V1.0
 */
public interface SysUserService extends IService<SysUser> {
   
   /**
    * @MethodName selectOneSelective
    * @Description TODO
    * @param sysUser 
    * @return com.coin.auth.web.entity.SysUser
    * @throws 
    * @author kh
    * @date 2020/2/27 20:00
    */
    SysUser selectOneSelective(SysUser sysUser) throws BaseException;

   /**
    * @MethodName selectSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
    SysUserDto selectSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName selectSysUsers
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
   IPage<SysUser> selectSysUsers(SysUserPo sysUser) throws BaseException;

   /**
   * @MethodName deleteSysUser
   * @Description TODO
   * @param sysUser
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/27 07:00:15.049
   */
   int deleteSysUserById(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName deleteSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:15.049
    */
   int deleteSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName deleteSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
   int deleteSysUsers(List<SysUserVo> sysUserList) throws BaseException;

   /**
    * @MethodName updateSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
   int updateSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName updateSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
   int updateSysUsers(List<SysUserVo> sysUserList) throws BaseException;

   /**
    * @MethodName insertSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
   int insertSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName insertSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:49.015
    */
   int insertSysUsers(List<SysUserVo> sysUserList) throws BaseException;

 }
