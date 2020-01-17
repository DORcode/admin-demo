package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
* @ClassName ${table.serviceImplName}
* @Description: TODO
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    private ${table.mapperName} ${table.mapperName?uncap_first};

    /**
     * @MethodName select${entity}
     * @Description TODO
     * @param ${entity}Vo
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
     * @MethodName select${entity}List
     * @Description TODO
     * @param List<${entity}Po>
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    public Result select${entity}List(List<${entity}Po> ${entity?uncap_first}List) throws BaseException {
        return Result.rows(1000l, null);
    }

    /**
     * @MethodName delete${entity}
     * @Description TODO
     * @param ${entity}Vo
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
     */
    public Result delete${entity}ById(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName delete${entity}
     * @Description TODO
     * @param ${entity}Vo
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
     */
    public Result delete${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Reslut.success();
    }

    /**
     * @MethodName delete${entity}List
     * @Description TODO
     * @param List<${entity}Po>
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    public Result delete${entity}List(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName update${entity}
     * @Description TODO
     * @param ${entity}Vo
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    public Result update${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName update${entity}List
     * @Description TODO
     * @param List<${entity}Vo>
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    public Result update${entity}List(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return Result.success();
    };

    /**
     * @MethodName insert${entity}
     * @Description TODO
     * @param ${entity}Po
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    Result insert${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return Result.success();
    }

    /**
     * @MethodName insert${entity}List
     * @Description TODO
     * @param List<${entity}Po>
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    public Result insert${entity}List(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        return Result.success();
    }
}
</#if>
