package com.coin.auth.web.mapper;

import com.coin.auth.web.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @ClassName SysUserRole
* @Description: SysUserRoleMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:85.015
    */
    int insertSelective(SysUserRole sysUserRole);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param sysUserRole
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:85.015
    */
    int updateByPrimaryKeySelective(SysUserRole sysUserRole);
}
