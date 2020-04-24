<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
    <#if field.type?upper_case?split("(")[0] == "INT">
        <id column="${field.name}" property="${field.propertyName}" jdbcType="INTEGER" />
    <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
        <id column="${field.name}" property="${field.propertyName}" jdbcType="TIMESTAMP" />
    <#else>
        <id column="${field.name}" property="${field.propertyName}" jdbcType="${field.type?upper_case?split("(")[0]}" />
    </#if>

</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
    <#if field.type?upper_case?split("(")[0] == "INT">
        <result column="${field.name}" property="${field.propertyName}" jdbcType="INTEGER" />
    <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
        <result column="${field.name}" property="${field.propertyName}" jdbcType="TIMESTAMP" />
    <#else>
        <result column="${field.name}" property="${field.propertyName}" jdbcType="${field.type?upper_case?split("(")[0]}" />
    </#if>

</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
    <#if field.type?upper_case?split("(")[0] == "INT">
        <result column="${field.name}" property="${field.propertyName}" jdbcType="INTEGER" />
    <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
        <result column="${field.name}" property="${field.propertyName}" jdbcType="TIMESTAMP" />
    <#else>
        <result column="${field.name}" property="${field.propertyName}" jdbcType="${field.type?upper_case?split("(")[0]}" />
    </#if>
</#if>
</#list>
    </resultMap>

</#if>

<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
<#list table.commonFields as field>
        ${field.name} ,
</#list>
        ${table.fieldNames}
    </sql>

</#if>

    <select id="selectOneSelective" parameterType="${package.Entity}.${entity}" resultType="${cfg.parentpackage}.vo.${entity}Vo">
        select * from ${table.name}
        <where>
        <#list table.fields as field>
        <if test="${field.propertyName} != null">
            <#if field.type?upper_case?split("(")[0] == "INT">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
            <#else>
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
            </#if>
        </if>
        </#list>
        </where>
    </select>

    <select id="select${entity}sPage" resultType="${cfg.parentpackage}.vo.${entity}Vo">
        select * from ${table.name}
        <where>
        <#list table.fields as field>
        <if test="${entity?uncap_first}.${field.propertyName} != null">
            <#if field.type?upper_case?split("(")[0] == "INT">
                ${field.name} = <#noparse>#{${entity?uncap_first}.</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                ${field.name} = <#noparse>#{${entity?uncap_first}.</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
            <#else>
                ${field.name} = <#noparse>#{${entity?uncap_first}.</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
            </#if>
        </if>
        </#list>
        </where>
    </select>

    <insert id="insertSelective" parameterType="${package.Entity}.${entity}" >
        insert into ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list table.fields as field>
        <if test="${field.propertyName} != null">
            ${field.name},
        </if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
        <#list table.fields as field>
        <if test="${field.propertyName} != null">
            <#if field.type?upper_case?split("(")[0] == "INT">
            {${field.propertyName}, jdbcType=INTEGER},
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
            {${field.propertyName}, jdbcType=TIMESTAMP},
            <#else>
            {${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}}},
            </#if>
        </if>
        </#list>
        </trim>
    </insert>

    <update id="updateByPrimaryKeySelective" parameterType="${cfg.parentpackage}.vo.${entity}Vo">
        update ${table.name}
        <set>
            <#list table.fields as field>
            <if test="${field.propertyName} != null">
            <#if field.type?upper_case?split("(")[0] == "INT">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
            <#else>
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
            </#if>
            </if>
            </#list>
        </set>
        <#list table.fields as field>
        <#if field.keyFlag>
        <#if field.type?upper_case?split("(")[0] == "INT">
            where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
        <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
            where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
        <#else>
            where  ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
        </#if>
        </#if>
        </#list>
    </update>
</mapper>
