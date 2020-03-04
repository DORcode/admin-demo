package com.coin.auth.web.mapper;

import com.coin.auth.web.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @ClassName SysRolePermission
* @Description: SysRolePermissionMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:993.014
    */
    int insertSelective(SysRolePermission sysRolePermission);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param sysRolePermission
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:993.014
    */
    int updateByPrimaryKeySelective(SysRolePermission sysRolePermission);
}
