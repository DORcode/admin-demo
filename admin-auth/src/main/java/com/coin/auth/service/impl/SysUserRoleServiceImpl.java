package com.coin.auth.service.impl;

import com.coin.auth.entity.SysUserRole;
import com.coin.auth.mapper.SysUserRoleMapper;
import com.coin.auth.service.SysUserRoleService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.util.Result;
import com.coin.auth.po.SysUserRolePo;
import com.coin.auth.vo.SysUserRoleVo;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysUserRoleServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/
@Slf4j
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * @MethodName selectSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName selectSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result selectSysUserRoles(List<SysUserRolePo> sysUserRoleList) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.187
     */
    @Override
    public Result deleteSysUserRoleById(SysUserRoleVo sysUserRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.187
     */
    @Override
    public Result deleteSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result deleteSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result updateSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result updateSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insertSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result insertSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insertSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:187.050
     */
    @Override
    public Result insertSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return Result.success();
    }
}
