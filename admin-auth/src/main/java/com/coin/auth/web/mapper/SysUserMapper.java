package com.coin.auth.web.mapper;

import com.coin.auth.web.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @ClassName SysUser
* @Description: SysUserMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectOneSelective(SysUser sysUser);

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param sysUser
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:45.015
    */
    int insertSelective(SysUser sysUser);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param sysUser
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:45.015
    */
    int updateByPrimaryKeySelective(SysUser sysUser);
}
