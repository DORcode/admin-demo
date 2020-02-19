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
     * @MethodName select${entity}
     * @Description TODO
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public Result select${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success(null);
    }

    /**
     * @MethodName select${entity}s
     * @Description TODO
     * @param ${entity?uncap_first}List
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @Override
    public Result select${entity}s(List<${entity}Po> ${entity?uncap_first}List) throws BaseException {
        return Result.rows(1000l, null);
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
    public Result delete${entity}ById(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
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
    public Result delete${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
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
    public Result delete${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return Result.success();
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
    public Result update${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
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
    public Result update${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return Result.success();
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
    public Result insert${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
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
    public Result insert${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return Result.success();
    }
}
</#if>
