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
        <id column="${field.name}" property="${field.propertyName}" jdbcType="${field.type?upper_case?split("(")[0]}" />
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
        <result column="${field.name}" property="${field.propertyName}" jdbcType="${field.type?upper_case?split("(")[0]}" />
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" jdbcType="${field.type?upper_case?split("(")[0]}" />
</#if>
</#list>
    </resultMap>

</#if>
<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
<#list table.commonFields as field>
        ${field.name},
</#list>
        ${table.fieldNames}
    </sql>

</#if>

    <select id="selectOneSelective" parameterType="${package.Entity}.${entity}">
        select * from sys_user
        <where>
            and IS_DELETE = 0
            <#list table.fields as field>
                <if test="${field.propertyName} != null">
                    and ${field.name} = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
                </if>
            </#list>
        </where>
    </select>

    <insert id="insertSelective" parameterType="${package.Entity}.${entity}" >
        insert into ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            <#list table.fields as field>
            <if test="${field.propertyName} != null">
                ${field.name },
            </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            <#list table.fields as field>
                <if test="${field.propertyName} != null">
                    {${field.propertyName}, jdbcType="${field.type?upper_case?split("(")[0]}"},
                </if>
            </#list>
        </trim>
    </insert>

    <update id="updateByPrimaryKeySelective" parameterType="${cfg.parentpackage}.vo.${entity}Vo">
        update ${table.name}
        <set>
            <#list table.fields as field>
                <if test="${field.propertyName} != null">
                    ${field.name} = <#noparse>#{</#noparse>${field.propertyName}, jdbcType="${field.type?upper_case?split("(")[0]}"<#noparse>}</#noparse>,
                </if>
            </#list>
        </set>
        where ID = <#noparse>#{</#noparse>id<#noparse>}</#noparse>
    </update>
</mapper>
