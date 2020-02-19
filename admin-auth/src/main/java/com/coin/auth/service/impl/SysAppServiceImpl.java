package com.coin.auth.service.impl;

import com.coin.auth.entity.SysApp;
import com.coin.auth.mapper.SysAppMapper;
import com.coin.auth.service.SysAppService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.util.Result;
import com.coin.auth.po.SysAppPo;
import com.coin.auth.vo.SysAppVo;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysAppServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/
@Slf4j
@Service
public class SysAppServiceImpl extends ServiceImpl<SysAppMapper, SysApp> implements SysAppService {

    @Autowired
    private SysAppMapper sysAppMapper;

    /**
     * @MethodName selectSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:967.049
     */
    @Override
    public Result selectSysApp(SysAppVo sysApp) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName selectSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:967.049
     */
    @Override
    public Result selectSysApps(List<SysAppPo> sysAppList) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:49.967
     */
    @Override
    public Result deleteSysAppById(SysAppVo sysApp) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:49.967
     */
    @Override
    public Result deleteSysApp(SysAppVo sysApp) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:967.049
     */
    @Override
    public Result deleteSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:968.049
     */
    @Override
    public Result updateSysApp(SysAppVo sysApp) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:968.049
     */
    @Override
    public Result updateSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insertSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:968.049
     */
    @Override
    public Result insertSysApp(SysAppVo sysApp) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insertSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:968.049
     */
    @Override
    public Result insertSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return Result.success();
    }
}
