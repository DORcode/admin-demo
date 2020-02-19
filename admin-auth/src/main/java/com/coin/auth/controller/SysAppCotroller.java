package com.coin.auth.controller;

import com.coin.auth.service.SysAppService;
import com.coin.auth.util.BaseException;
import com.coin.auth.vo.SysAppVo;
import com.coin.auth.po.SysAppPo;
import com.coin.auth.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName SysAppCotroller
* @Description: 应用
* @Author kh
* @Date 2020-02-19
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
     * @date 2020/02/19 09:09:983.049
     */
    @RequestMapping("selectSysApp")
    @ApiOperation(value="查询应用")
    public Result selectSysApp(SysAppVo sysApp) throws BaseException {
        return sysAppService.selectSysApp(sysApp);
    }

    /**
     * @MethodName selectSysApps
     * @Description TODO
     * @param sysAppList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:984.049
     */
    @RequestMapping("selectSysApps")
    @ApiOperation(value="查询应用")
    public Result selectSysApps(List<SysAppPo> sysAppList) throws BaseException {
        return sysAppService.selectSysApps(sysAppList);
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:49.984
     */
    @RequestMapping("deleteSysAppById")
    @ApiOperation(value="根据主键删除应用")
    public Result deleteSysAppById(SysAppVo sysApp) throws BaseException {
        return sysAppService.deleteSysAppById(sysApp);
    }

    /**
     * @MethodName deleteSysApp
     * @Description TODO
     * @param sysApp
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:49.984
     */
    @RequestMapping("deleteSysApp")
    @ApiOperation(value="删除应用")
    public Result deleteSysApp(SysAppVo sysApp) throws BaseException {
        return sysAppService.deleteSysApp(sysApp);
    }

    /**
    * @MethodName deleteSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:984.049
    */
    @RequestMapping("deleteSysApps")
    @ApiOperation(value="删除多个应用")
    public Result deleteSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return sysAppService.deleteSysApps(sysAppList);
    }

    /**
    * @MethodName updateSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:984.049
    */
    @RequestMapping("updateSysApp")
    @ApiOperation(value="更新应用")
    public Result updateSysApp(SysAppVo sysApp) throws BaseException {
        return sysAppService.updateSysApp(sysApp);
    }

    /**
    * @MethodName updateSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:984.049
    */
    @RequestMapping("updateSysApps")
    @ApiOperation(value="更新多个应用")
    public Result updateSysApps(List<SysAppVo> sysAppList) throws BaseException {
        return sysAppService.updateSysApps(sysAppList);
    }

    /**
    * @MethodName insertSysApp
    * @Description TODO
    * @param sysApp
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:985.049
    */
    @RequestMapping("insertSysApp")
    @ApiOperation(value="插入应用")
    public Result insertSysApp(SysAppVo sysApp) throws BaseException {
        return sysAppService.insertSysApp(sysApp);
    }

    /**
    * @MethodName insertSysApps
    * @Description TODO
    * @param sysAppList
    * @return
    * @throws BaseException
    * @author
    * @date 2020/02/19 09:09:985.049
    */
    @RequestMapping("insertSysApps")
    @ApiOperation(value="插入多个应用")
    public Result insertSysApps(List<SysAppVo> sysAppList) throws BaseException  {
        return sysAppService.insertSysApps(sysAppList);
    }

}
