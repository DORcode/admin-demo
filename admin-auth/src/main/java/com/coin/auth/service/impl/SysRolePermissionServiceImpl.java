package com.coin.auth.service.impl;

import com.coin.auth.entity.SysRolePermission;
import com.coin.auth.mapper.SysRolePermissionMapper;
import com.coin.auth.service.SysRolePermissionService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.util.Result;
import com.coin.auth.po.SysRolePermissionPo;
import com.coin.auth.vo.SysRolePermissionVo;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysRolePermissionServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/
@Slf4j
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * @MethodName selectSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:101.050
     */
    @Override
    public Result selectSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName selectSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:101.050
     */
    @Override
    public Result selectSysRolePermissions(List<SysRolePermissionPo> sysRolePermissionList) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.101
     */
    @Override
    public Result deleteSysRolePermissionById(SysRolePermissionVo sysRolePermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.101
     */
    @Override
    public Result deleteSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:101.050
     */
    @Override
    public Result deleteSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:101.050
     */
    @Override
    public Result updateSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:101.050
     */
    @Override
    public Result updateSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insertSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:102.050
     */
    @Override
    public Result insertSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insertSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:102.050
     */
    @Override
    public Result insertSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return Result.success();
    }
}
