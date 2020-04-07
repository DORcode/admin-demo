package com.coin.auth.web.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.auth.web.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coin.auth.web.po.SysUserRolePo;
import com.coin.auth.web.vo.SysRoleVo;
import com.coin.auth.web.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * @MethodName selectRelatedSysUsers
     * @Description TODO
     * @param page
     * @param sysUserRole 
     * @return java.util.List<com.coin.auth.web.vo.SysUserVo>
     * @throws 
     * @author kh
     * @date 2020/4/1 17:23
     */
    List<SysUserVo> selectRelatedSysUsers(Page page, @Param("sr") SysUserRolePo sysUserRole);
    /**
     * @MethodName selectUnrelatedSysUsers
     * @Description TODO
     * @param page
     * @param sysUserRole
     * @return java.util.List<com.coin.auth.web.vo.SysUserVo>
     * @throws 
     * @author kh
     * @date 2020/4/1 16:56
     */
    List<SysUserVo> selectUnrelatedSysUsers(Page page, @Param("sr") SysUserRolePo sysUserRole);

    /**
     * @MethodName deleteByRoleId
     * @Description TODO
     * @param roleId
     * @return int
     * @throws
     * @author kh
     * @date 2020/3/10 17:47
     */
    int deleteByRoleId(@Param("roleId") String roleId);

    /**
     * @MethodName selectSysRoleVo
     * @Description 根据用户id查询用户关联的角色
     * @param userId
     * @return List<SysRoleVo>
     * @throws
     * @author kh
     * @date 2020/3/12 20:52
     */
    List<SysRoleVo> selectSysRoleVo(@Param("userId") String userId);
}
