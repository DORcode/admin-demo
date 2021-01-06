package com.coin.admintest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @ClassName InfoBase
* @Description: InfoBaseMapper
* @Author kh
* @Date 2020-10-20
* @Version V1.0
*/
@Mapper
public interface InfoBaseMapper {

    @Select("select * from info_base where id=#{id}")
    List<InfoBase> selectList(String id);

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param infoBase
    * @return
    * @throws
    * @author
    * @date 2020/10/20 04:02:999.027
    */
    int insertSelective(InfoBase infoBase);

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param infoBase
    * @return
    * @throws
    * @author
    * @date 2020/10/20 04:02:999.027
    */
    int updateByPrimaryKeySelective(InfoBase infoBase);
}
