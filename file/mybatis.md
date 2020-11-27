<resultMap type="java.util.Map" id="table_field_resultMap">
    <result column="P_MENU_NAME" property="p_menuName" jdbcType="VARCHAR"/>
    <collection property="subMenus" ofType="java.util.Map" javaType="java.util.ArrayList" >
        <result column="MENU_NAME" property="menuName" jdbcType="VARCHAR"/>
        <result column="LAST_MENU_ID" property="lastMenuId" jdbcType="VARCHAR"/>
        <result column="CODE" property="code" jdbcType="VARCHAR"/>
        <result column="ORDER_" property="order" jdbcType="NUMERIC"/>
        <collection property="tables" ofType="java.util.Map" javaType="java.util.ArrayList" >
            <result column="TABLE_NAME" property="tableName" jdbcType="VARCHAR"/>
            <result column="TABLE_CODE" property="tableCode" jdbcType="VARCHAR"/>
            <collection property="fields" ofType="java.util.Map"  javaType="java.util.ArrayList" >
                <result column="FIELDNAME" property="fieldName" jdbcType="VARCHAR"/>
                <result column="NAME" property="name" jdbcType="VARCHAR"/>
                <result column="SORT" property="sort" jdbcType="NUMERIC"/>
            </collection>
        </collection>
    </collection>
</resultMap>
	
https://mybatis.org/mybatis-3/sqlmap-xml.html#Result_Maps
	
<insert id="insertAuthor" useGeneratedKeys="true"
    keyProperty="id">
  insert into Author (username, password, email, bio) values
  <foreach item="item" collection="list" separator=",">
    (#{item.username}, #{item.password}, #{item.email}, #{item.bio})
  </foreach>
</insert>

<sql id="userColumns"> ${alias}.id,${alias}.username,${alias}.password </sql>

<select id="selectUsers" resultType="map">
  select
    <include refid="userColumns"><property name="alias" value="t1"/></include>,
    <include refid="userColumns"><property name="alias" value="t2"/></include>
  from some_table t1
    cross join some_table t2
</select>

# 参数
#{property,javaType=int,jdbcType=NUMERIC}
#{age,javaType=int,jdbcType=NUMERIC,typeHandler=MyTypeHandler}

#{height,javaType=double,jdbcType=NUMERIC,numericScale=2}

#{department, mode=OUT, jdbcType=CURSOR, javaType=ResultSet, resultMap=departmentResultMap}

Integer current_page = map.get("current_page") == null ? 1: Integer.parseInt(String.valueOf(map.get("current_page")));
Integer page_size = map.get("page_size") == null ? 15 : Integer.parseInt(String.valueOf(map.get("page_size")));
Object sort_map = map.get("sort_map");
Object search_filters = map.get("search_filters");
Page page = new Page(current_page, page_size);
if (search_filters != null) {
    List filters = (List) search_filters;
    for (Object o : filters) {
        Map f = (Map) o;
        if (String.valueOf(f.get("property_name")).equals("name")) {
            f.put("column", "empNm");
        }

        if (String.valueOf(f.get("property_name")).equals("type")) {
            f.put("column", "addvcdLevel");
        }

        if (String.valueOf(f.get("property_name")).equals("areaCode")) {
            f.put("column", "addvcd");
        }
    }
}

<select id="selectEtUserNewPage" resultType="Map">
    select * from et_user_new
    <where>
        <if test="1 == 1">
            1 = 1
        </if>
        <if test="map != null and map.search_filters.size > 0">
            <foreach collection="map.search_filters" item="item">
                <choose>
                    <when test="item.match_type == 'LIKE'">
                        and ${item.column} like concat('%', #{item.value}, '%')
                    </when>
                    <when test="item.match_type == 'ALLIN'">
                        and ${item.column} in
                        <foreach item="id" collection='item.value.split(",")' open="(" separator="," close=")">
                            #{id}
                        </foreach>
                    </when>
                    <when test="item.match_type == 'EQ'">
                        and ${item.column} = #{item.value}
                    </when>
                    <otherwise>
                    </otherwise>
                </choose>

            </foreach>
        </if>
    </where>
</select>