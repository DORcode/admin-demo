package ${package.Controller};


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

    @RequestMapping("")
    @ApiOperation(value="${table.comment!""}", response=UserEntity.class)
    <#if restControllerStyle == false>
        @ResponseBody
    </#if>

}
</#if>
</#if>
