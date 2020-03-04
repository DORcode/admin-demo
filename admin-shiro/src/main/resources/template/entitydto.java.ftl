package ${cfg.parentpackage}.dto;

<#list table.importPackages as pkg>
<#if pkg != 'com.baomidou.mybatisplus.annotation.TableId'
&& pkg != 'com.baomidou.mybatisplus.annotation.TableField'
&& pkg != 'com.baomidou.mybatisplus.activerecord.Model'
&& pkg != 'com.baomidou.mybatisplus.annotation.TableName'>
import ${pkg};
</#if>
</#list>
<#if entityLombokModel>

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>

/**
* @ClassName ${entity}Dto
* @Description: ${table.comment!""}
* @Author ${author}
* @Date ${date}
* @Version V1.0
*/
<#if entityLombokModel>
@Data
<#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
<#else>
@EqualsAndHashCode(callSuper = false)
</#if>
@Accessors(chain = true)
</#if>
public class ${entity}Dto implements Serializable {

    private static final long serialVersionUID = 1L;
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
<#if field.keyFlag>
<#assign keyPropertyName="${field.propertyName}"/>
</#if>

<#if field.comment!?length gt 0>
    /**
     * ${field.comment}
     */
</#if>
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->

<#if !entityLombokModel>
<#list table.fields as field>
<#if field.propertyType == "boolean">
    <#assign getprefix="is"/>
<#else>
    <#assign getprefix="get"/>
</#if>
    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }

<#if entityBuilderModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
<#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
</#if>
        this.${field.propertyName} = ${field.propertyName};
<#if entityBuilderModel>
        return this;
</#if>
    }
</#list>
</#if>

<#if !entityLombokModel>
    @Override
    public String toString() {
        return "${entity}{" +
<#list table.fields as field>
<#if field_index==0>
        "${field.propertyName}=" + ${field.propertyName} +
<#else>
        ", ${field.propertyName}=" + ${field.propertyName} +
</#if>
</#list>
        "}";
    }
</#if>
}
