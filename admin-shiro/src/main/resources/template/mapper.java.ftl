package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

/**
* @ClassName ${entity}
* @Description: ${table.mapperName}
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
