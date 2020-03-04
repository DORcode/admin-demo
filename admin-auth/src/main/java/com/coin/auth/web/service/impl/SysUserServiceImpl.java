package com.coin.auth.web.service.impl;

import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.mapper.SysUserMapper;
import com.coin.auth.web.service.SysUserService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysUserPo;
import com.coin.auth.web.vo.SysUserVo;
import com.coin.auth.web.dto.SysUserDto;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysUserServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectOneSelective(SysUser sysUser) throws BaseException {
        SysUser user = sysUserMapper.selectOneSelective(sysUser);
        return user;
    }

    /**
     * @MethodName selectSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:740.035
     */
    @Override
    public SysUserDto selectSysUser(SysUserVo sysUser) throws BaseException {

        return null;
    }

    /**
     * @MethodName selectSysUsers
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:740.035
     */
    @Override
    public List<SysUserVo> selectSysUsers(SysUserPo sysUser) throws BaseException {
        return null;
    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.741
     */
    @Override
    public int deleteSysUserById(SysUserVo sysUser) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.741
     */
    @Override
    public int deleteSysUser(SysUserVo sysUser) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:741.035
     */
    @Override
    public int deleteSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:741.035
     */
    @Override
    public int updateSysUser(SysUserVo sysUser) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:741.035
     */
    @Override
    public int updateSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return 1;
    };

    /**
     * @MethodName insertSysUser
     * @Description TODO
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:741.035
     */
    @Override
    public int insertSysUser(SysUserVo sysUser) throws BaseException {
        return 1;
    }

    /**
     * @MethodName insertSysUsers
     * @Description TODO
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:741.035
     */
    @Override
    public int insertSysUsers(List<SysUserVo> sysUserList) throws BaseException {
        return 1;
    }
}
