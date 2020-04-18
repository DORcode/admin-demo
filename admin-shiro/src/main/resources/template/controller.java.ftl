package ${package.Controller};

import ${package.Service}.${table.serviceName};
import ${cfg.utilpackage}.BaseException;
import ${cfg.parentpackage}.vo.${entity}Vo;
import ${cfg.parentpackage}.po.${entity}Po;
import ${cfg.parentpackage}.dto.${entity}Dto;
import ${cfg.utilpackage}.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
* @ClassName ${table.controllerName}
* @Description: ${table.comment!""}
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/

@Slf4j
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

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    /**
    * @MethodName select${entity}ById
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    @GetMapping("select${entity}/{id}")
    @ApiOperation(value="查询${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result select${entity}ById(@PathVariable("id") String id) throws BaseException {
        ${table.serviceName?uncap_first}.select${entity}ById(id);
        return Result.success();
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
    @PostMapping("select${entity}")
    @ApiOperation(value="查询${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result select${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        ${table.serviceName?uncap_first}.select${entity}(${entity?uncap_first});
        return Result.success();
    }

    /**
     * @MethodName select${entity}s
     * @Description TODO
     * @param ${entity?uncap_first}
     * @return
     * @throws BaseException
     * @author
     * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
     */
    @PostMapping("select${entity}s")
    @ApiOperation(value="查询${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result select${entity}s(${entity}Po ${entity?uncap_first}) throws BaseException {
        ${table.serviceName?uncap_first}.select${entity}s(${entity?uncap_first});
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
    @GetMapping("delete${entity}/{id}")
    @ApiOperation(value="根据主键删除${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result delete${entity}ById(@PathVariable("id") String id) throws BaseException {
        ${table.serviceName?uncap_first}.delete${entity}ById(id);
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
    @PostMapping("delete${entity}s")
    @ApiOperation(value="删除多个${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result delete${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        ${table.serviceName?uncap_first}.delete${entity}s(${entity?uncap_first}List);
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
    @PostMapping("update${entity}")
    @ApiOperation(value="更新${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result update${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        ${table.serviceName?uncap_first}.update${entity}(${entity?uncap_first});
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
    @PostMapping("update${entity}s")
    @ApiOperation(value="更新多个${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result update${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException {
        ${table.serviceName?uncap_first}.update${entity}s(${entity?uncap_first}List);
        return Result.success();
    }

    /**
    * @MethodName insert${entity}
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    @PostMapping("insert${entity}")
    @ApiOperation(value="插入${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result insert${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException {
        ${table.serviceName?uncap_first}.insert${entity}(${entity?uncap_first});
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
    @PostMapping("insert${entity}s")
    @ApiOperation(value="插入多个${table.comment!""}")
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>
    public Result insert${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException  {
        ${table.serviceName?uncap_first}.insert${entity}s(${entity?uncap_first}List);
        return Result.success();
    }

}
</#if>
</#if>
