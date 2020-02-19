package com.coin.auth.service;

import com.coin.auth.entity.SysApp;
import com.baomidou.mybatisplus.service.IService;
import com.coin.auth.util.BaseException;
import com.coin.auth.util.Result;
import com.coin.auth.po.SysAppPo;
import com.coin.auth.vo.SysAppVo;
import java.util.List;

/**
 * @ClassName SysAppService
 * @Description: TODO
 * @Author kh
 * @Date 2020-02-19
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
    * @date 2020/02/19 09:09:935.049
    */
   Result selectSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName selectSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:939.049
    */
   Result selectSysApps(List<SysAppPo> sysAppList) throws BaseException;

   /**
   * @MethodName deleteSysApp
   * @Description TODO
   * @param sysApp
   * @return
   * @throws BaseException
   * @author
   * @date 2020/02/19 09:09:49.939
   */
   Result deleteSysAppById(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName deleteSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:49.939
    */
   Result deleteSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName deleteSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:939.049
    */
   Result deleteSysApps(List<SysAppVo> sysAppList) throws BaseException;

   /**
    * @MethodName updateSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:939.049
    */
   Result updateSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName updateSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:939.049
    */
   Result updateSysApps(List<SysAppVo> sysAppList) throws BaseException;

   /**
    * @MethodName insertSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:939.049
    */
   Result insertSysApp(SysAppVo sysApp) throws BaseException;

   /**
    * @MethodName insertSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:939.049
    */
   Result insertSysApps(List<SysAppVo> sysAppList) throws BaseException;

 }
