package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${cfg.utilpackage}.Result;
import ${cfg.parentpackage}.po.${entity}Po;
import ${cfg.parentpackage}.vo.${entity}Vo;

import java.util.List;

/**
 * @ClassName ${table.serviceName}
 * @Description: TODO
 * @Author ${author}
 * @Date ${date}
 * @Version V1.0
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

   /**
    * @MethodName select${entity}
    * @Description TODO
    * @param ${entity}Vo
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   Result select${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

   /**
    * @MethodName select${entity}List
    * @Description TODO
    * @param List<${entity}Po>
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   Result select${entity}List(List<${entity}Po> ${entity?uncap_first}List) throws BaseException;

   /**
   * @MethodName delete${entity}
   * @Description TODO
   * @param ${entity}Vo
   * @return
   * @throws BaseException
   * @author
   * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
   */
   Result delete${entity}ById(${entity}Vo ${entity?uncap_first}) throws BaseException;
   /**
    * @MethodName delete${entity}
    * @Description TODO
    * @param ${entity}Vo
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
    */
   Result delete${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

   /**
    * @MethodName delete${entity}List
    * @Description TODO
    * @param List<${entity}Po>
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   Result delete${entity}List(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

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
    * @MethodName update${entity}List
    * @Description TODO
    * @param List<${entity}Vo>
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   Result update${entity}List(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

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
    * @MethodName insert${entity}List
    * @Description TODO
    * @param List<${entity}Po>
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   Result insert${entity}List(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

 }
</#if>
