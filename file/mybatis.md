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