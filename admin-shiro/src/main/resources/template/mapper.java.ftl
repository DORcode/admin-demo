package ${package.Mapper};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${superMapperClassPackage};
import org.apache.ibatis.annotations.Mapper;
import ${cfg.parentpackage}.po.${entity}Po;
import ${cfg.parentpackage}.vo.${entity}Vo;
import ${cfg.parentpackage}.dto.${entity}Dto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @ClassName ${entity}
* @Description: ${table.mapperName}
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/
@Mapper
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    /**
    * @MethodName selectOneSelective
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    ${entity}Vo selectOneSelective(${entity}Vo ${entity?uncap_first});

    /**
    * @MethodName select${entity}sPage
    * @Description TODO
    * @param page
    * @param ${entity?uncap_first}
    * @return
    * @throws
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    List<${entity}Vo> select${entity}sPage(Page page, @Param("${entity?uncap_first}") ${entity}Po ${entity?uncap_first});

    /**
    * @MethodName insertSelective
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    int insertSelective(${entity} ${entity?uncap_first});

    /**
    * @MethodName updateByPrimaryKeySelective
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    int updateByPrimaryKeySelective(${entity}Vo ${entity?uncap_first});
}
</#if>
