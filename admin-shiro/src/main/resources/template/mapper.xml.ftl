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
    <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
        <id column="${field.name}" property="${field.propertyName}" jdbcType="LONGVARCHAR" />
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
    <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
        <result column="${field.name}" property="${field.propertyName}" jdbcType="LONGVARCHAR" />
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
    <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
        <result column="${field.name}" property="${field.propertyName}" jdbcType="LONGVARCHAR" />
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

    <select id="selectOneSelective" parameterType="${cfg.parentpackage}.vo.${entity}Vo" resultType="${cfg.parentpackage}.vo.${entity}Vo">
        select * from ${table.name}
        <where>
        <#list table.fields as field>
        <if test="${field.propertyName} != null">
        <#if field.type?upper_case?split("(")[0] == "INT">
           AND ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>
        <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
            AND ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>
        <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
            AND  ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>
        <#else>
            AND  ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>
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
            AND ${field.name} = <#noparse>{</#noparse>${entity?uncap_first}.${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
            AND ${field.name} = <#noparse>#{</#noparse>${entity?uncap_first}.${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>
            <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
            AND ${field.name} = <#noparse>#{</#noparse>${entity?uncap_first}.${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>
            <#else>
            AND ${field.name} = <#noparse>#{</#noparse>${entity?uncap_first}.${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>
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
            <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
        <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
            <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
        <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
            <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
        <#else>
            <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
        </#if>
        </if>
        </#list>
        </trim>
    </insert>

    <insert id="insert${entity}s" parameterType="${package.Entity}.${entity}">
        insert into ${table.name}

        <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list table.fields as field>
            ${field.name},
        </#list>
        </trim>
        <foreach collection="list" item="item" separator=",">
            <trim prefix="values (" suffix=")" suffixOverrides="," >
            <#list table.fields as field>
            <#if field.type?upper_case?split("(")[0] == "INT">
                <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
                <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
            <#else>
                <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
            </#if>
            </#list>
            </trim>
        </foreach>
    </insert>

    <update id="update${entity}s">
        <foreach collection="list" item="item" separator=",">
            update ${table.name}
            <set>
            <#list table.fields as field>
            <if test="${field.propertyName} != null">
            <#if field.type?upper_case?split("(")[0] == "INT">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
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
                <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
                    where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
                <#else>
                    where  ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>
                </#if>
            </#if>
            </#list>
        </foreach>
    </update>

    <update id="updateByPrimaryKey" parameterType="${cfg.parentpackage}.vo.${entity}Vo">
        update ${table.name}
        <set>
            <#list table.fields as field>
                <#if field.type?upper_case?split("(")[0] == "INT">
                    ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
                <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                    ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
                <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
                    ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
                <#else>
                    ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>,
                </#if>
            </#list>
        </set>
        <#list table.fields as field>
            <#if field.keyFlag>
                <#if field.type?upper_case?split("(")[0] == "INT">
                    where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
                <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                    where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
                <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
                    where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
                <#else>
                    where  ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>
                </#if>
            </#if>
        </#list>
    </update>

    <update id="updateByPrimaryKeySelective" parameterType="${cfg.parentpackage}.vo.${entity}Vo">
        update ${table.name}
        <set>
            <#list table.fields as field>
            <if test="${field.propertyName} != null">
            <#if field.type?upper_case?split("(")[0] == "INT">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=INTEGER<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "DATETIME">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=TIMESTAMP<#noparse>}</#noparse>,
            <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
                ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
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
        <#elseif field.type?upper_case?split("(")[0] == "TEXT" || field.type?upper_case?split("(")[0] == "LONGTEXT">
            where ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=LONGVARCHAR<#noparse>}</#noparse>,
        <#else>
            where  ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType=${field.type?upper_case?split("(")[0]}<#noparse>}</#noparse>
        </#if>
        </#if>
        </#list>
    </update>
</mapper>
