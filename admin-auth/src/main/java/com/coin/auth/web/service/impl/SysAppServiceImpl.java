package com.coin.auth.web.service.impl;

import com.coin.auth.web.entity.SysApp;
import com.coin.auth.web.mapper.SysAppMapper;
import com.coin.auth.web.service.SysAppService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysAppPo;
import com.coin.auth.web.vo.SysAppVo;
import com.coin.auth.web.dto.SysAppDto;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysAppServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-27
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
     * @date 2020/02/27 07:26:410.035
     */
    @Override
    public SysAppDto selectSysApp(SysAppVo sysApp) throws BaseException {
        return null;
    }

    /**
     * @MethodName selectSysApps
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:410.035
     */
    @Override
    public List<SysAppVo> selectSysApps(SysAppPo sysApp) throws BaseException {
        return null;
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.410
     */
    @Override
    public int deleteSysAppById(SysAppVo sysApp) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.410
     */
    @Override
    public int deleteSysApp(SysAppVo sysApp) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:410.035
     */
    @Override
    public int deleteSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:410.035
     */
    @Override
    public int updateSysApp(SysAppVo sysApp) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:411.035
     */
    @Override
    public int updateSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return 1;
    };

    /**
     * @MethodName insertSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:411.035
     */
    @Override
    public int insertSysApp(SysAppVo sysApp) throws BaseException {
        return 1;
    }

    /**
     * @MethodName insertSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:411.035
     */
    @Override
    public int insertSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return 1;
    }
}
