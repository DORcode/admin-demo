package com.coin.auth.service.impl;

import com.coin.auth.entity.SysPermission;
import com.coin.auth.mapper.SysPermissionMapper;
import com.coin.auth.service.SysPermissionService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.util.Result;
import com.coin.auth.po.SysPermissionPo;
import com.coin.auth.vo.SysPermissionVo;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysPermissionServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/
@Slf4j
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * @MethodName selectSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:25.050
     */
    @Override
    public Result selectSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName selectSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:25.050
     */
    @Override
    public Result selectSysPermissions(List<SysPermissionPo> sysPermissionList) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.025
     */
    @Override
    public Result deleteSysPermissionById(SysPermissionVo sysPermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.026
     */
    @Override
    public Result deleteSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:26.050
     */
    @Override
    public Result deleteSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:26.050
     */
    @Override
    public Result updateSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:26.050
     */
    @Override
    public Result updateSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insertSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:26.050
     */
    @Override
    public Result insertSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insertSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:26.050
     */
    @Override
    public Result insertSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        return Result.success();
    }
}
