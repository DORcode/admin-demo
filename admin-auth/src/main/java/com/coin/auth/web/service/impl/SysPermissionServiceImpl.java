package com.coin.auth.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.coin.auth.config.shiro.ShiroUtil;
import com.coin.auth.util.BeanUtil;
import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.util.TreeUtil;
import com.coin.auth.web.entity.SysPermission;
import com.coin.auth.web.mapper.SysPermissionMapper;
import com.coin.auth.web.mapper.SysRolePermissionMapper;
import com.coin.auth.web.service.SysPermissionService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coin.auth.web.vo.Menu;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.dto.SysPermissionDto;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
* @ClassName SysPermissionServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Slf4j
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public Set<String> selectPermissionsByUserId(String userId) {
        return sysPermissionMapper.selectPermissionsByUserId(userId);
    }

    /**
     * @MethodName selectSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:544.035
     */
    @Override
    public SysPermissionVo selectSysPermission(SysPermissionVo sysPermission) throws BaseException {
        QueryWrapper<SysPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", sysPermission.getId()).eq("isDelete", "0");
        SysPermission permission = sysPermissionMapper.selectOne(queryWrapper);
        SysPermissionVo sysPermissionVo = new SysPermissionVo();
        BeanUtil.copyProperties(sysPermissionVo, permission);
        return sysPermissionVo;
    }

    /**
     * @MethodName selectSysPermissions
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:544.035
     */
    @Override
    public List<SysPermissionVo> selectSysPermissions(SysPermissionPo sysPermission) throws BaseException {
        return null;
    }

    /**
     * @MethodName selectMenuList
     * @Description 查询树形
     * @param
     * @return java.util.List<com.coin.auth.web.vo.Menu>
     * @throws
     * @author kh
     * @date 2020/3/9 20:16
     */
    @Override
    public List<Menu> selectMenuList() throws BaseException {
        String userId = ShiroUtil.getUserId();
        List<Menu> menus = sysPermissionMapper.selectMenuList(userId);
        return TreeUtil.getMenuTree(menus);
    }

    @Override
    public List<SysPermissionVo> selectPermissionList() {
        List<SysPermissionVo> list = sysPermissionMapper.selectPermissionList();
        return TreeUtil.getSysPermissionTree(list);
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.544
     */
    @Override
    public int deleteSysPermissionById(SysPermissionVo sysPermission) throws BaseException {
        UpdateWrapper<SysPermission> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", sysPermission.getId());
        SysPermission permission = new SysPermission();
        permission.setIsDelete("1");
        int i = sysPermissionMapper.update(permission, updateWrapper);
        if(i != 1) {
            throw new BaseException(ResultCodeEnum.DELETE_FAIL);
        }
        return i;
    }

    /**
     * @MethodName deleteSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.544
     */
    @Override
    public int deleteSysPermission(SysPermissionVo sysPermission) throws BaseException {
        SysPermission permission = new SysPermission();
        permission.setIsDelete("1");
        UpdateWrapper<SysPermission> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", sysPermission.getId());
        sysPermissionMapper.update(permission, updateWrapper);

        // 删除与权限关联的，角色权限表数据
        sysRolePermissionMapper.deleteByPermissionId(sysPermission.getId());
        return 1;
    }

    /**
     * @MethodName deleteSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:544.035
     */
    @Override
    public int deleteSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        List<SysPermission> list = new ArrayList<>();
        for(SysPermissionVo sp : sysPermissionList) {
            SysPermission permission = new SysPermission();
            BeanUtil.copyProperties(permission, sp);
            permission.setIsDelete("1");
            list.add(permission);
        }
        updateBatchById(list);
        return 1;
    }

    /**
     * @MethodName updateSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:544.035
     */
    @Override
    public int updateSysPermission(SysPermissionVo sysPermission) throws BaseException {
        int num = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        if(num != 1) {
            throw new BaseException(ResultCodeEnum.UPDATE_FAIL);
        }
        return 1;
    }

    /**
     * @MethodName updateSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:544.035
     */
    @Override
    public int updateSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        List<SysPermission> list = new ArrayList<>();
        for(SysPermissionVo sp : sysPermissionList) {
            SysPermission permission = new SysPermission();
            BeanUtil.copyProperties(permission, sp);
            list.add(permission);
        }
        updateBatchById(list, 1000);
        return list.size();
    };

    /**
     * @MethodName insertSysPermission
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:544.035
     */
    @Override
    public int insertSysPermission(SysPermissionVo sysPermission) throws BaseException {
        SysPermission permission = new SysPermission();
        BeanUtil.copyProperties(permission, sysPermission);
        Map map = new HashMap<>();
        if (StringUtils.isNotEmpty(sysPermission.getPCode())) {
            map.put("upcode", sysPermission.getPCode());
        } else {
            map.put("upcode", 0);
        }

        map.put("name", "menu");
        map.put("glide", 0);
        sysPermissionMapper.getcode(map);
        BigDecimal gd = (BigDecimal) map.get("glide");
        String format = new DecimalFormat("0000").format(gd);
        if (StringUtils.isNotEmpty(sysPermission.getPCode())) {
            permission.setCode(sysPermission.getPCode() + format);
        } else {
            permission.setCode(format);
        }

        int i = sysPermissionMapper.insert(permission);
        return i;
    }

    /**
     * @MethodName insertSysPermissions
     * @Description TODO
     * @param sysPermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:545.035
     */
    @Override
    public int insertSysPermissions(List<SysPermissionVo> sysPermissionList) throws BaseException {
        List<SysPermission> list = new ArrayList<>();
        for(SysPermissionVo sp : sysPermissionList) {
            SysPermission permission = new SysPermission();
            BeanUtil.copyProperties(permission, sp);
            list.add(permission);
        }
        int size = list.size();
        int num = 1000;
        int step;
        if(size % num == 0) {
            step = size / num;
        } else {
            step = size / num + 1;
        }

        for(int i=0; i< step; i++) {
            int from = i * num;
            int to = (i + 1) * num;
            if (to > size) {
                to = size;
            }
            boolean b = saveBatch(list.subList(from, to));
        }
        return size;
    }
}
