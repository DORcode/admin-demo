package com.coin.auth.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.config.YmlConfig;
import com.coin.auth.util.BeanUtil;
import com.coin.auth.util.EncryptUtil;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.mapper.SysUserMapper;
import com.coin.auth.web.service.SysUserService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysUserPo;
import com.coin.auth.web.vo.SysUserVo;
import com.coin.auth.web.dto.SysUserDto;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    private YmlConfig ymlConfig;

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
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", sysUser.getId()).eq("isDelete", "0");
        SysUser user = sysUserMapper.selectOne(queryWrapper);
        SysUserDto sysUserDto = new SysUserDto();
        BeanUtil.copyProperties(sysUserDto, user);
        return sysUserDto;
    }

    /**
     * @MethodName selectSysUsers
     * @Description 分页查询，此处生成模板需要修改
     * @param sysUser
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:740.035
     */
    @Override
    public IPage<SysUser> selectSysUsers(SysUserPo sysUser) throws BaseException {
        Page<SysUser> page = new Page<>(sysUser.getCurrent(), sysUser.getSize());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete", "0");
        if (StringUtils.isNotEmpty(sysUser.getName())) {
            queryWrapper.and(wraper -> wraper.like("name", sysUser.getName()));
        }
        if(StringUtils.isNotEmpty(sysUser.getUsername())) {
            queryWrapper.and(wraper -> wraper.like("username", sysUser.getUsername()));
        }
        if(StringUtils.isNotEmpty(sysUser.getSex())) {
            queryWrapper.and(wrapper -> wrapper.eq("sex", sysUser.getSex()));
        }

        if(StringUtils.isNotEmpty(sysUser.getMobile())) {
            queryWrapper.and(wraper -> wraper.like("mobile", sysUser.getMobile()));
        }
        if(StringUtils.isNotEmpty(sysUser.getCode())) {
            queryWrapper.and(wraper -> wraper.like("code", sysUser.getCode()));
        }
        if(null != sysUser.getCreateTimeStart() || null != sysUser.getCreateTimeEnd()) {
            LocalDateTime begin = null != sysUser.getCreateTimeStart() ? sysUser.getCreateTimeStart() : LocalDateTime.now();
            LocalDateTime end = null != sysUser.getCreateTimeEnd() ? sysUser.getCreateTimeEnd() : LocalDateTime.now();
            queryWrapper.and(wrapper -> wrapper.between("create_time", begin, end));
        }

        if(null != sysUser.getUpdateTimeStart() || null != sysUser.getUpdateTimeEnd()) {
            LocalDateTime begin = null != sysUser.getUpdateTimeStart() ? sysUser.getUpdateTimeStart() : LocalDateTime.now();
            LocalDateTime end = null != sysUser.getUpdateTimeEnd() ? sysUser.getUpdateTimeEnd() : LocalDateTime.now();
            queryWrapper.and(wrapper -> wrapper.between("update_time", begin, end));
        }

        IPage<SysUser> userIPage = sysUserMapper.selectPage(page, queryWrapper);
        return userIPage;
    }

    /**
     * @MethodName deleteSysUser
     * @Description 这个方法修改为String类型参数
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
        SysUser user = new SysUser();
        BeanUtil.copyProperties(user, sysUser);
        user.setIsDelete("1");
        user.setUpdateTime(LocalDateTime.now());
        int num = sysUserMapper.updateById(user);
        return num;
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
        int num = 0;
        for(SysUserVo su : sysUserList) {
            num += this.deleteSysUser(su);
        }
        return num;
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
        SysUser user = new SysUser();
        BeanUtil.copyProperties(user, sysUser);
        user.setUpdateTime(LocalDateTime.now());
        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", sysUser.getId());
        int num = sysUserMapper.update(user, updateWrapper);
        return num;
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
        if(StringUtils.isEmpty(sysUser.getName()) || StringUtils.isEmpty(sysUser.getUsername())) {
            throw new BaseException(ResultCodeEnum.PARAM_IS_NULL);
        }

        if (StringUtils.isEmpty(sysUser.getPassword())) {
            String enc = EncryptUtil.md5("123456", ymlConfig.getSalt(), ymlConfig.getIteration());
            sysUser.setPassword(enc);
        }
        SysUser user = new SysUser();
        BeanUtil.copyProperties(user, sysUser);
        user.setIsDelete("0");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(user.getCreateTime());
        // code需要生成
        int num = sysUserMapper.insert(user);
        if(num != 1) {
            throw new BaseException(ResultCodeEnum.SAVE_FAIL);
        }
        return num;
    }

    /**
     * @MethodName insertSysUsers
     * @Description 批量保存
     * @param sysUserList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:741.035
     */
    @Override
    public int insertSysUsers(List<SysUserVo> sysUserList) throws BaseException {

        int num = 0;
        for(SysUserVo su : sysUserList) {
            num += this.insertSysUser(su);
        }
        if(num != sysUserList.size()) {
            throw new BaseException(ResultCodeEnum.SAVE_FAIL);
        }
        return num;
    }
}
