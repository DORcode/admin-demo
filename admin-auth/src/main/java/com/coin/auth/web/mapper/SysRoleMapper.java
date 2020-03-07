package com.coin.auth.web.mapper;

import com.coin.auth.web.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coin.auth.web.vo.SysRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
* @ClassName SysRole
* @Description: SysRoleMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {


    Set<String> selectSysRoleNamesByUserId(@Param("userId") String userId);


    List<SysRole> selectSysRoleByUserId(@Param("userId")  String userId);

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param sysRole
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:949.014
    */
    int insertSelective(SysRole sysRole);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param sysRole
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:949.014
    */
    int updateByPrimaryKeySelective(SysRoleVo sysRole);
}
