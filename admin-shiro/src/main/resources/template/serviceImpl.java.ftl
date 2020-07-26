package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${cfg.utilpackage}.BaseException;
import ${cfg.utilpackage}.BeanUtil;
import ${superServiceImplClassPackage};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${cfg.utilpackage}.Result;
import ${cfg.parentpackage}.po.${entity}Po;
import ${cfg.parentpackage}.vo.${entity}Vo;
import ${cfg.parentpackage}.dto.${entity}Dto;

import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;
import java.util.List;

/**
* @ClassName ${table.serviceImplName}
* @Description: TODO
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/
@Slf4j
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} ${table.mapperName?uncap_first};

    /**
    * @MethodName select${entity}ById
    * @Description TODO
    * @param id
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    @Override
    public ${entity}Vo select${entity}ById(Serializable id) throws BaseException {
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        <#list table.fields as field>
        <#if field.keyFlag>
        queryWrapper.lambda().eq(${entity}::get${field.propertyName?cap_first}, id);
        </#if>
        </#list>
        ${entity} ${entity?uncap_first} = ${table.mapperName?uncap_first}.selectOne(queryWrapper);
        ${entity}Vo ${entity?uncap_first}Vo = new ${entity}Vo();
        if(null != ${entity?uncap_first}) {
            BeanUtil.copyProperties(${entity?uncap_first}Vo, ${entity?uncap_first});
        }
        return ${entity?uncap_first}Vo;
    }

    /**
     * @MethodName select${entity}
     * @Description TODO
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public ${entity}Vo select${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return null;
    }

    /**
     * @MethodName select${entity}sPage
     * @Description TODO
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public IPage<${entity}Vo> select${entity}sPage(${entity}Po ${entity?uncap_first}) throws BaseException {
        Page page = new Page(${entity?uncap_first}.getCurrent(), ${entity?uncap_first}.getSize());
        return page.setRecords(${table.mapperName?uncap_first}.select${entity}sPage(page, ${entity?uncap_first}));
    }

    /**
     * @MethodName delete${entity}ById
     * @Description TODO
     * @param id
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
     */
    @Override
    public int delete${entity}ById(Serializable id) throws BaseException {
        return 1;
    }

    /**
     * @MethodName delete${entity}s
     * @Description TODO
     * @param ${entity?uncap_first}List
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public int delete${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return 1;
    }

    /**
     * @MethodName update${entity}
     * @Description TODO
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public int update${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        ${table.mapperName?uncap_first}.updateByPrimaryKeySelective(${entity?uncap_first});
        return 1;
    }

    /**
     * @MethodName update${entity}s
     * @Description TODO
     * @param ${entity?uncap_first}List
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public int update${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return 1;
    };

    /**
     * @MethodName insert${entity}
     * @Description TODO
     * @param ${entity?uncap_first}Vo
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public int insert${entity}(${entity}Vo ${entity?uncap_first}Vo) throws BaseException {
        ${entity} ${entity?uncap_first} = new ${entity}();
        BeanUtil.copyProperties(${entity?uncap_first}, ${entity?uncap_first}Vo);
        ${table.mapperName?uncap_first}.insert(${entity?uncap_first});
        return 1;
    }

    /**
     * @MethodName insert${entity}s
     * @Description TODO
     * @param ${entity?uncap_first}List
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public int insert${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        for(${entity}Vo ${entity?uncap_first} : ${entity?uncap_first}List) {
            insert${entity}(${entity?uncap_first});
        }
        return ${entity?uncap_first}List.size();
    }
}
</#if>
