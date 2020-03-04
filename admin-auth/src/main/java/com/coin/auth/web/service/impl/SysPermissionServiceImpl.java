package com.coin.auth.web.service.impl;

import com.coin.auth.web.entity.SysPermission;
import com.coin.auth.web.mapper.SysPermissionMapper;
import com.coin.auth.web.service.SysPermissionService;
import com.coin.auth.util.BaseException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.dto.SysPermissionDto;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Set;

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
    public SysPermissionDto selectSysPermission(SysPermissionVo sysPermission) throws BaseException {
        return null;
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
        return 0;
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
        return 0;
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
        return 1;
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
        return 1;
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
        return 1;
    }
}
