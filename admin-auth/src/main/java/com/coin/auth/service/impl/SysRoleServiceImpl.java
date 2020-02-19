package com.coin.auth.service.impl;

import com.coin.auth.entity.SysRole;
import com.coin.auth.mapper.SysRoleMapper;
import com.coin.auth.service.SysRoleService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.util.Result;
import com.coin.auth.po.SysRolePo;
import com.coin.auth.vo.SysRoleVo;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysRoleServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * @MethodName selectSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:60.050
     */
    @Override
    public Result selectSysRole(SysRoleVo sysRole) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName selectSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:60.050
     */
    @Override
    public Result selectSysRoles(List<SysRolePo> sysRoleList) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.060
     */
    @Override
    public Result deleteSysRoleById(SysRoleVo sysRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.060
     */
    @Override
    public Result deleteSysRole(SysRoleVo sysRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:60.050
     */
    @Override
    public Result deleteSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:60.050
     */
    @Override
    public Result updateSysRole(SysRoleVo sysRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:61.050
     */
    @Override
    public Result updateSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insertSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:61.050
     */
    @Override
    public Result insertSysRole(SysRoleVo sysRole) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insertSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:61.050
     */
    @Override
    public Result insertSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return Result.success();
    }
}
