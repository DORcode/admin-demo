package com.coin.auth.web.service.impl;

import com.coin.auth.web.entity.SysUserRole;
import com.coin.auth.web.mapper.SysUserRoleMapper;
import com.coin.auth.web.service.SysUserRoleService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysUserRolePo;
import com.coin.auth.web.vo.SysUserRoleVo;
import com.coin.auth.web.dto.SysUserRoleDto;

import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
* @ClassName SysUserRoleServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-27
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
     * @date 2020/02/27 07:26:810.035
     */
    @Override
    public SysUserRoleDto selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return null;
    }

    /**
     * @MethodName selectSysUserRoles
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:811.035
     */
    @Override
    public List<SysUserRoleVo> selectSysUserRoles(SysUserRolePo sysUserRole) throws BaseException {
        return null;
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.811
     */
    @Override
    public int deleteSysUserRoleById(SysUserRoleVo sysUserRole) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.811
     */
    @Override
    public int deleteSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:811.035
     */
    @Override
    public int deleteSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:811.035
     */
    @Override
    public int updateSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:811.035
     */
    @Override
    public int updateSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return 1;
    };

    /**
     * @MethodName insertSysUserRole
     * @Description TODO
     * @param sysUserRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:811.035
     */
    @Override
    public int insertSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
        return 1;
    }

    /**
     * @MethodName insertSysUserRoles
     * @Description TODO
     * @param sysUserRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:811.035
     */
    @Override
    public int insertSysUserRoles(List<SysUserRoleVo> sysUserRoleList) throws BaseException {
        return 1;
    }
}
