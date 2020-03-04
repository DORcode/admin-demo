package com.coin.auth.web.mapper;

import com.coin.auth.web.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
* @ClassName SysPermission
* @Description: SysPermissionMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * @MethodName selectPermissionsByUserId
     * @Description TODO
     * @param userId
     * @return java.util.Set<java.lang.String>
     * @throws
     * @author kh
     * @date 2020/2/28 10:16
     */
    Set<String> selectPermissionsByUserId(@Param("userId") String userId);

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:910.014
    */
    int insertSelective(SysPermission sysPermission);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param sysPermission
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:910.014
    */
    int updateByPrimaryKeySelective(SysPermission sysPermission);
}
