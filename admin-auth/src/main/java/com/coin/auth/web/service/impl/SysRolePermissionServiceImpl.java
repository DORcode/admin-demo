package com.coin.auth.web.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.util.BeanUtil;
import com.coin.auth.web.entity.SysRolePermission;
import com.coin.auth.web.mapper.SysRolePermissionMapper;
import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.service.SysRolePermissionService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coin.auth.web.vo.SysPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysRolePermissionPo;
import com.coin.auth.web.vo.SysRolePermissionVo;
import com.coin.auth.web.dto.SysRolePermissionDto;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
* @ClassName SysRolePermissionServiceImpl
* @Description: TODO
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Slf4j
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    /**
     * @MethodName selectSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public SysRolePermissionDto selectSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return null;
    }

    /**
     * @MethodName selectSysRolePermissions
     * @Description TODO
     * @param sysPermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public IPage<SysPermissionVo> selectSysRolePermissions(Page page,
               SysPermissionPo sysPermission) throws BaseException {
        return page.setRecords(sysRolePermissionMapper.selectSysRolePermissionsPage(page, sysPermission));
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.628
     */
    @Override
    public int deleteSysRolePermissionById(SysRolePermissionVo sysRolePermission) throws BaseException {
        sysRolePermission.setIsDelete("1");
        int num = sysRolePermissionMapper.updateByPrimaryKeySelective(sysRolePermission);
        return num;
    }

    /**
     * @MethodName deleteSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:35.628
     */
    @Override
    public int deleteSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return 0;
    }

    /**
     * @MethodName deleteSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public int deleteSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public int updateSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        return 1;
    }

    /**
     * @MethodName updateSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public int updateSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        return 1;
    };

    /**
     * @MethodName insertSysRolePermission
     * @Description TODO
     * @param sysRolePermission
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public int insertSysRolePermission(SysRolePermissionVo sysRolePermission) throws BaseException {
        SysRolePermission p = new SysRolePermission();
        BeanUtil.copyProperties(p, sysRolePermission);
        int num = sysRolePermissionMapper.insert(p);
        return num;
    }

    /**
     * @MethodName insertSysRolePermissions
     * @Description TODO
     * @param sysRolePermissionList
     * @return
     * @throws BaseException
     * @author
     * @date 2020/02/27 07:26:628.035
     */
    @Override
    public int insertSysRolePermissions(List<SysRolePermissionVo> sysRolePermissionList) throws BaseException {
        List<SysRolePermission> list = new ArrayList<>();
        for(SysRolePermissionVo sp: sysRolePermissionList) {
            SysRolePermission permission = new SysRolePermission();
            BeanUtil.copyProperties(permission, sp);
            list.add(permission);
        }
        saveBatch(list);
        return list.size();
    }
}
