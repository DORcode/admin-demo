package com.coin.auth.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.util.BeanUtil;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.entity.SysRole;
import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.mapper.SysRoleMapper;
import com.coin.auth.web.mapper.SysRolePermissionMapper;
import com.coin.auth.web.mapper.SysUserRoleMapper;
import com.coin.auth.web.service.SysRoleService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysRolePo;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.dto.SysRoleDto;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
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

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

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
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", sysRole.getId()).eq("isDelete", "0");

        SysRole role = sysRoleMapper.selectOne(queryWrapper);

        SysRoleDto sysRoleDto = new SysRoleDto();
        BeanUtil.copyProperties(sysRoleDto, role);
        return sysRoleDto;
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
    public IPage<SysRole> selectSysRoles(SysRolePo sysRole) throws BaseException {
        Page<SysRole> page = new Page<>(sysRole.getCurrent(), sysRole.getSize());
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getIsDelete, "0");
        if (StringUtils.isNotEmpty(sysRole.getName())) {
            queryWrapper.and(wraper -> wraper.like(SysRole::getName, sysRole.getName()));
        }

        if (StringUtils.isNotEmpty(sysRole.getCode())) {
            queryWrapper.and(wraper -> wraper.like(SysRole::getCode, sysRole.getCode()));
        }

        if(null != sysRole.getCreateTimeStart() || null != sysRole.getCreateTimeEnd()) {
            LocalDateTime begin = null != sysRole.getCreateTimeStart() ? sysRole.getCreateTimeStart() : LocalDateTime.now();
            LocalDateTime end = null != sysRole.getCreateTimeEnd() ? sysRole.getCreateTimeEnd() : LocalDateTime.now();
            queryWrapper.and(wrapper -> wrapper.between(SysRole::getCreateTime, begin, end));
        }

        if(null != sysRole.getUpdateTimeStart() || null != sysRole.getUpdateTimeEnd()) {
            LocalDateTime begin = null != sysRole.getUpdateTimeStart() ? sysRole.getUpdateTimeStart() : LocalDateTime.now();
            LocalDateTime end = null != sysRole.getUpdateTimeEnd() ? sysRole.getUpdateTimeEnd() : LocalDateTime.now();
            queryWrapper.and(wrapper -> wrapper.between(SysRole::getUpdateTime, begin, end));
        }
        IPage<SysRole> roleIPage = sysRoleMapper.selectPage(page, queryWrapper);
        return roleIPage;
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
        sysRole.setIsDelete("1");
        int i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);

        //删除 用户 角色 关联
        sysUserRoleMapper.deleteByRoleId(sysRole.getId());

        //删除 角色 权限 关联
        sysRolePermissionMapper.deleteByRoleId(sysRole.getId());

        int num = i;
        if(num != 1) {
            throw new BaseException(ResultCodeEnum.SAVE_FAIL);
        }
        return num;
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
        for(SysRoleVo sr : sysRoleList) {
            this.deleteSysRoleById(sr);
        }
        return sysRoleList.size();
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
        int num = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        return num;
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
        SysRole role = new SysRole();
        BeanUtil.copyProperties(role, sysRole);
        role.setCreateTime(LocalDateTime.now());
        role.setUpdateTime(role.getCreateTime());
        int num = sysRoleMapper.insert(role);
        if(num != 1) {
            throw new BaseException(ResultCodeEnum.SAVE_FAIL);
        }
        return num;
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
        for(SysRoleVo sr : sysRoleList) {
            this.insertSysRole(sr);
        }
        return sysRoleList.size();
    }
}
