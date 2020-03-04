package com.coin.auth.web.mapper;

import com.coin.auth.web.entity.SysApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @ClassName SysApp
* @Description: SysAppMapper
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
public interface SysAppMapper extends BaseMapper<SysApp> {

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param sysApp
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:716.014
    */
    int insertSelective(SysApp sysApp);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param sysApp
    * @return
    * @throws
    * @author
    * @date 2020/02/27 07:00:721.014
    */
    int updateByPrimaryKeySelective(SysApp sysApp);
}
