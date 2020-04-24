package ${package.Service};

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import ${cfg.utilpackage}.BaseException;
import ${cfg.utilpackage}.Result;
import ${cfg.parentpackage}.po.${entity}Po;
import ${cfg.parentpackage}.vo.${entity}Vo;
import ${cfg.parentpackage}.dto.${entity}Dto;
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
    * @MethodName select${entity}ById
    * @Description TODO
    * @param id
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    ${entity}Vo select${entity}ById(Serializable id) throws BaseException;

   /**
    * @MethodName select${entity}
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    ${entity}Vo select${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

   /**
    * @MethodName select${entity}sPage
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
    IPage<${entity}Vo> select${entity}sPage(${entity}Po ${entity?uncap_first}) throws BaseException;

   /**
   * @MethodName delete${entity}
   * @Description TODO
   * @param id
   * @return
   * @throws BaseException
   * @author
   * @date ${.now?string["yyyy/MM/dd hh:mm:ss.SSS"]}
   */
   int delete${entity}ById(Serializable id) throws BaseException;

   /**
    * @MethodName delete${entity}s
    * @Description TODO
    * @param ${entity?uncap_first}List
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   int delete${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

   /**
    * @MethodName update${entity}
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   int update${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

   /**
    * @MethodName update${entity}s
    * @Description TODO
    * @param ${entity?uncap_first}List
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   int update${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

   /**
    * @MethodName insert${entity}
    * @Description TODO
    * @param ${entity?uncap_first}
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   int insert${entity}(${entity}Vo ${entity?uncap_first}) throws BaseException;

   /**
    * @MethodName insert${entity}s
    * @Description TODO
    * @param ${entity?uncap_first}List
    * @return
    * @throws BaseException
    * @author
    * @date ${.now?string["yyyy/MM/dd hh:mm:SS.sss"]}
    */
   int insert${entity}s(List<${entity}Vo> ${entity?uncap_first}List) throws BaseException;

 }
</#if>
