package com.coin.auth.service.impl;

import com.coin.auth.entity.SysUser;
import com.coin.auth.mapper.SysUserMapper;
import com.coin.auth.service.SysUserService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.util.Result;
import com.coin.auth.po.SysUserPo;
import com.coin.auth.vo.SysUserVo;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysUserServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-19
* @Version V1.0
*/
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * @MethodName selectSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:147.050
     */
    @Override
    public Result selectSysUser(SysUserVo sysUser) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName selectSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:147.050
     */
    @Override
    public Result selectSysUsers(List<SysUserPo> sysUserList) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.147
     */
    @Override
    public Result deleteSysUserById(SysUserVo sysUser) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:50.147
     */
    @Override
    public Result deleteSysUser(SysUserVo sysUser) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName deleteSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:148.050
     */
    @Override
    public Result deleteSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:148.050
     */
    @Override
    public Result updateSysUser(SysUserVo sysUser) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName updateSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:148.050
     */
    @Override
    public Result updateSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insertSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:148.050
     */
    @Override
    public Result insertSysUser(SysUserVo sysUser) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insertSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/19 09:09:148.050
     */
    @Override
    public Result insertSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return Result.success();
    }
}
