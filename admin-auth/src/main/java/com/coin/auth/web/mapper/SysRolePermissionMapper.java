package com.coin.auth.web.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.web.entity.SysRolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coin.auth.web.po.SysPermissionPo;
import com.coin.auth.web.vo.SysPermissionVo;
import com.coin.auth.web.vo.SysRolePermissionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName SysRolePermission
* @Description: SysRolePermissionMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {
    
    /**
     * @MethodName selectSysRolePermissionsPage
     * @Description TODO
     * @param page
 * @param sysPermission
     * @return java.util.List<com.coin.auth.web.vo.SysPermissionVo>
     * @throws 
     * @author kh
     * @date 2020/3/13 9:29
     */
    List<SysPermissionVo> selectSysRolePermissionsPage(Page page, @Param("sp") SysPermissionPo sysPermission);

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
    int updateByPrimaryKeySelective(SysRolePermissionVo sysRolePermission);
    
    /**
     * @MethodName deleteByRoleId
     * @Description TODO
     * @param roleId 
     * @return int
     * @throws 
     * @author kh
     * @date 2020/3/10 17:35
     */
    int deleteByRoleId(@Param("roleId") String roleId);

    /**
     * @param permissionId
     * @return int
     * @throws
     * @MethodName deleteByPermissionId
     * @Description TODO
     * @author kh
     * @date 2020/3/10 17:17
     */
    int deleteByPermissionId(@Param("permissionId") String permissionId);
}
