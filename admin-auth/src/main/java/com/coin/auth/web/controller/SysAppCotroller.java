package com.coin.auth.web.controller;

import com.coin.auth.web.service.SysAppService;
import com.coin.auth.util.BaseException;
import com.coin.auth.web.vo.SysAppVo;
import com.coin.auth.web.po.SysAppPo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysAppCotroller
* @Description: 应用
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/

@Slf4j
@RestController
@RequestMapping("/api/sysapp")
@Api(tags="应用")
public class SysAppCotroller {

    @Autowired
    private SysAppService sysAppService;

    /**
     * @MethodName selectSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:758.014
     */
    @RequestMapping("selectSysApp")
    @ApiOperation(value="查询应用")
    public Result selectSysApp(SysAppVo sysApp) throws BaseException {
        sysAppService.selectSysApp(sysApp);
        return Result.success();
    }

    /**
     * @MethodName selectSysApps
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:758.014
     */
    @RequestMapping("selectSysApps")
    @ApiOperation(value="查询应用")
    public Result selectSysApps(SysAppPo sysApp) throws BaseException {
        sysAppService.selectSysApps(sysApp);
        return Result.success();
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:14.758
     */
    @RequestMapping("deleteSysAppById")
    @ApiOperation(value="根据主键删除应用")
    public Result deleteSysAppById(SysAppVo sysApp) throws BaseException {
        sysAppService.deleteSysAppById(sysApp);
        return Result.success();
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:00:14.759
     */
    @RequestMapping("deleteSysApp")
    @ApiOperation(value="删除应用")
    public Result deleteSysApp(SysAppVo sysApp) throws BaseException {
        sysAppService.deleteSysApp(sysApp);
        return Result.success();
    }

    /**
    * @MethodName deleteSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:759.014
    */
    @RequestMapping("deleteSysApps")
    @ApiOperation(value="删除多个应用")
    public Result deleteSysApps(List<SysAppVo> sysAppList) throws BaseException {
        sysAppService.deleteSysApps(sysAppList);
        return Result.success();
    }

    /**
    * @MethodName updateSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:759.014
    */
    @RequestMapping("updateSysApp")
    @ApiOperation(value="更新应用")
    public Result updateSysApp(SysAppVo sysApp) throws BaseException {
        sysAppService.updateSysApp(sysApp);
        return Result.success();
    }

    /**
    * @MethodName updateSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:759.014
    */
    @RequestMapping("updateSysApps")
    @ApiOperation(value="更新多个应用")
    public Result updateSysApps(List<SysAppVo> sysAppList) throws BaseException {
        sysAppService.updateSysApps(sysAppList);
        return Result.success();
    }

    /**
    * @MethodName insertSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:759.014
    */
    @RequestMapping("insertSysApp")
    @ApiOperation(value="插入应用")
    public Result insertSysApp(SysAppVo sysApp) throws BaseException {
        sysAppService.insertSysApp(sysApp);
        return Result.success();
    }

    /**
    * @MethodName insertSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/27 07:00:759.014
    */
    @RequestMapping("insertSysApps")
    @ApiOperation(value="插入多个应用")
    public Result insertSysApps(List<SysAppVo> sysAppList) throws BaseException  {
        sysAppService.insertSysApps(sysAppList);
        return Result.success();
    }

}
