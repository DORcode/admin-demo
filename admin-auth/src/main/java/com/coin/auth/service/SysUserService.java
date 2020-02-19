package com.coin.auth.service;

import com.coin.auth.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.po.SysUserPo;
import com.coin.auth.vo.SysUserVo;
import java.util.List;

/**
 * @ClassName SysUserService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-19
 * @Version V1.0
 */
public interface SysUserService extends IService<SysUser> {

   /**
    * @MethodName selectSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:142.050
    */
   Result selectSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName selectSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:142.050
    */
   Result selectSysUsers(List<SysUserPo> sysUserList) throws BaseException;

   /**
   * @MethodName deleteSysUser
   * @Description TODO
   * @param sysUser
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/19 09:09:50.143
   */
   Result deleteSysUserById(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName deleteSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:50.143
    */
   Result deleteSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName deleteSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:143.050
    */
   Result deleteSysUsers(List<SysUserVo> sysUserList) throws BaseException;

   /**
    * @MethodName updateSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:143.050
    */
   Result updateSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName updateSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:143.050
    */
   Result updateSysUsers(List<SysUserVo> sysUserList) throws BaseException;

   /**
    * @MethodName insertSysUser
    * @Description TODO
    * @param sysUser
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:143.050
    */
   Result insertSysUser(SysUserVo sysUser) throws BaseException;

   /**
    * @MethodName insertSysUsers
    * @Description TODO
    * @param sysUserList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:143.050
    */
   Result insertSysUsers(List<SysUserVo> sysUserList) throws BaseException;

 }
