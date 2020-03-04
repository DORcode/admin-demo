package com.coin.auth.web.service;

import com.coin.auth.web.entity.SysApp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.po.SysAppPo;
import com.coin.auth.web.vo.SysAppVo;
import com.coin.auth.web.dto.SysAppDto;
import java.util.List;

/**
 * @ClassName SysAppService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-27
 * @Version V1.0
 */
public interface SysAppService extends IService<SysApp> {

   /**
    * @MethodName selectSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:730.014
    */
    SysAppDto selectSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName selectSysApps
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:730.014
    */
    List<SysAppVo> selectSysApps(SysAppPo sysApp) throws BaseException;

   /**
   * @MethodName deleteSysApp
   * @Description TODO
   * @param sysApp
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/27 07:00:14.731
   */
   int deleteSysAppById(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName deleteSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:14.731
    */
   int deleteSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName deleteSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:731.014
    */
   int deleteSysApps(List<SysAppVo> sysAppList) throws BaseException;

   /**
    * @MethodName updateSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:731.014
    */
   int updateSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName updateSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:731.014
    */
   int updateSysApps(List<SysAppVo> sysAppList) throws BaseException;

   /**
    * @MethodName insertSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:731.014
    */
   int insertSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName insertSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:731.014
    */
   int insertSysApps(List<SysAppVo> sysAppList) throws BaseException;

 }
