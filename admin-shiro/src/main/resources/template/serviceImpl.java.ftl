package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${cfg.utilpackage}.BaseException;
import ${superServiceImplClassPackage};
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${cfg.utilpackage}.Result;
import ${cfg.parentpackage}.po.${entity}Po;
import ${cfg.parentpackage}.vo.${entity}Vo;
import ${cfg.parentpackage}.dto.${entity}Dto;

import lombok.extern.slf4j.Slf4j;
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
    public ${entity}Vo select${entity}ById(String id) throws BaseException {
        return null;
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
    public List<${entity}Vo> select${entity}sPage(${entity}Po ${entity?uncap_first}) throws BaseException {
        return null;
    }

    /**
     * @MethodName delete${entity}
     * @Description TODO
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
     */
    @Override
    public int delete${entity}ById(String id) throws BaseException {
        return 0;
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
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public int insert${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
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
        return 1;
    }
}
</#if>
