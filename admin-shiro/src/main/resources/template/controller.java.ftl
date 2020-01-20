package ${package.Controller};

import ${package.Service}.${table.serviceName}
import ${cfg.utilpackage}.BaseException;
import ${cfg.parentpackage}.vo.${entity}Vo;
import ${cfg.parentpackage}.vo.${entity}Po;
import ${cfg.utilpackage}.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
* @ClassName ${table.controllerName}
* @Description: ${table.comment!""}
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if cfg.controllerFirstName??>/${cfg.controllerFirstName?lower_case}</#if><#if package.ModuleName??>/${package.ModuleName?lower_case}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen?lower_case}<#else>${table.entityPath?lower_case}</#if>")
@Api(tags="${table.comment!""}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {

    @Override
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
     * @MethodName select${entity}
     * @Description TODO
     * @param ${entity}Vo
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @RequestMapping("select")
    @ApiOperation(value="${table.comment!""}", response=UserEntity.class)
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result select${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        return ${table.serviceName?uncap_first}.select${entity}(${entity?uncap_first});
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
    @RequestMapping("select")
    @ApiOperation(value="${table.comment!""}", response=UserEntity.class)
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result select${entity}s(List<${entity}Po> ${entity?uncap_first}List) throws BaseException {
        return ${table.serviceName?uncap_first}.select${entity}List(${entity?uncap_first}List);
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
        return ${table.serviceName?uncap_first}.delete${entity}ById(${entity?uncap_first});
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
        return ;
    }

        /**
        * @MethodName delete${entity}s
        * @Description TODO
        * @param List<${entity}Po>
            * @return
            * @throws BaseException
            * @author
            * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
            */
            Result delete${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

                /**
                * @MethodName update${entity}
                * @Description TODO
                * @param ${entity}Vo
                * @return
                * @throws BaseException
                * @author
                * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
                */
                Result update${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

                /**
                * @MethodName update${entity}s
                * @Description TODO
                * @param List<${entity}Vo>
                    * @return
                    * @throws BaseException
                    * @author
                    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
                    */
                    Result update${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

                        /**
                        * @MethodName insert${entity}
                        * @Description TODO
                        * @param ${entity}Po
                        * @return
                        * @throws BaseException
                        * @author
                        * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
                        */
                        Result insert${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

                        /**
                        * @MethodName insert${entity}s
                        * @Description TODO
                        * @param List<${entity}Po>
                            * @return
                            * @throws BaseException
                            * @author
                            * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
                            */
                            Result insert${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

}
</#if>
</#if>
