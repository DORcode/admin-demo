package com.coin.auth.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.coin.auth.util.BeanUtil;
import com.coin.auth.web.entity.SysUserRole;
import com.coin.auth.web.mapper.SysUserRoleMapper;
import com.coin.auth.web.service.SysUserRoleService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coin.auth.web.vo.SysRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysUserRolePo;
import com.coin.auth.web.vo.SysUserRoleVo;
import com.coin.auth.web.dto.SysUserRoleDto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
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
    public SysRoleVo selectSysUserRole(SysUserRoleVo sysUserRole) throws BaseException {
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
    public List<SysRoleVo> selectSysUserRoles(SysUserRolePo sysUserRole) throws BaseException {
        return sysUserRoleMapper.selectSysRoleVo(sysUserRole.getUserId());
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
        UpdateWrapper<SysUserRole> wrapper = new UpdateWrapper<>();
        SysUserRole userRole = new SysUserRole();
        userRole.setIsDelete("1");
        wrapper.eq("id", sysUserRole.getId());
        sysUserRoleMapper.update(userRole, wrapper);
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
        SysUserRole role = new SysUserRole();
        BeanUtil.copyProperties(role, sysUserRole);
        int num = sysUserRoleMapper.insert(role);
        return num;
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
        List<SysUserRole> list = new ArrayList<>();
        for(SysUserRoleVo ur : sysUserRoleList) {
            SysUserRole sysUserRole = new SysUserRole();
            BeanUtil.copyProperties(sysUserRole, ur);
            list.add(sysUserRole);
        }
        saveBatch(list);
        return list.size();
    }
}
