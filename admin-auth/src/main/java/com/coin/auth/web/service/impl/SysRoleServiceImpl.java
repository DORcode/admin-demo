package com.coin.auth.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.coin.auth.web.entity.SysRole;
import com.coin.auth.web.mapper.SysRoleMapper;
import com.coin.auth.web.service.SysRoleService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysRolePo;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.dto.SysRoleDto;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Set;

/**
* @ClassName SysRoleServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> selectSysRoleNamesByUserId(String userId) {

        return sysRoleMapper.selectSysRoleNamesByUserId(userId);
    }

    @Override
    public List<SysRole> selectSysRoleByUserId(String userId) {
        return sysRoleMapper.selectSysRoleByUserId(userId);
    }

    /**
     * @MethodName selectSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public SysRoleDto selectSysRole(SysRoleVo sysRole) throws BaseException {
        return null;
    }

    /**
     * @MethodName selectSysRoles
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public List<SysRoleVo> selectSysRoles(SysRolePo sysRole) throws BaseException {
        return null;
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.590
     */
    @Override
    public int deleteSysRoleById(SysRoleVo sysRole) throws BaseException {

        return 0;
    }

    /**
     * @MethodName deleteSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.590
     */
    @Override
    public int deleteSysRole(SysRoleVo sysRole) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public int deleteSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public int updateSysRole(SysRoleVo sysRole) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public int updateSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return 1;
    };

    /**
     * @MethodName insertSysRole
     * @Description TODO
     * @param sysRole
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public int insertSysRole(SysRoleVo sysRole) throws BaseException {
        return 1;
    }

    /**
     * @MethodName insertSysRoles
     * @Description TODO
     * @param sysRoleList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:590.035
     */
    @Override
    public int insertSysRoles(List<SysRoleVo> sysRoleList) throws BaseException {
        return 1;
    }
}
