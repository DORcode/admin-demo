<resultMap id="noticeSendMap" type="com.cjwsjy.workreport.web.vo.NoticeSendVo">
        <id column="id" property="id" jdbcType="BIGINT"/>

        <result column="send_user_id" property="sendUserId" jdbcType="BIGINT"/>
        <result column="msg" property="msg" jdbcType="VARCHAR"/>
        <result column="title" property="title" jdbcType="VARCHAR"/>
        <result column="realname" property="sendUserName" jdbcType="VARCHAR"/>
        <result column="org_name" property="orgName" jdbcType="VARCHAR"/>
        <result column="is_read" property="isRead" jdbcType="CHAR"/>
        <result column="is_delete" property="isDelete" jdbcType="CHAR"/>
        <result column="create_time" property="createTime" jdbcType="TIMESTAMP"/>
        <result column="update_time" property="updateTime" jdbcType="TIMESTAMP"/>
        <collection property="replys" javaType="list"
                    ofType="com.cjwsjy.workreport.web.vo.NoticeReplyVo" select="selectNoticeReplys"
                    column="{userId=userId, id=id, isSelf=isSelf}">
            <result column="id" property="id" jdbcType="BIGINT"/>
            <result column="reply_id" property="replyId" jdbcType="BIGINT"/>
            <result column="receive_user_id" property="receiveUserId" jdbcType="BIGINT"/>
            <result column="receive_user_name" property="receiveUserName" jdbcType="VARCHAR"/>
            <result column="org_name" property="orgName" jdbcType="VARCHAR"/>
            <result column="is_reply" property="isReply" jdbcType="CHAR"/>
            <result column="msg" property="msg" jdbcType="VARCHAR"/>
            <result column="is_read" property="isRead" jdbcType="CHAR"/>
            <result column="is_delete" property="isDelete" jdbcType="CHAR"/>
            <result column="create_time" property="createTime" jdbcType="TIMESTAMP"/>
            <result column="update_time" property="updateTime" jdbcType="TIMESTAMP"/>
        </collection>
    </resultMap>

    <select id="selectNoticeSendsPage" resultMap="noticeSendMap">
        select distinct ns.*, #{noticeSend.userId, jdbcType=BIGINT} userId,
        if(#{noticeSend.userId, jdbcType=BIGINT}=ns.send_user_id,1, 0) isSelf, if(isnull(su.realname),'系统',su.realname),
        so.org_name
        from notice_send ns left join notice_reply nr on ns.id = nr.send_id
        left join sys_user su on ns.send_user_id = su.id left join sys_org so on su.org_id = so.id
        <where>
            <if test="noticeSend.id != null">
                AND ns.id = #{noticeSend.id, jdbcType=BIGINT}
            </if>
            <if test="noticeSend.sendUserId != null">
                AND ns.send_user_id = #{noticeSend.sendUserId, jdbcType=BIGINT}
            </if>
            <if test="noticeSend.msg != null">
                AND ns.msg = #{noticeSend.msg, jdbcType=VARCHAR}
            </if>
            <if test="1 == 1">
                AND ns.is_delete = 0
            </if>
            <if test="noticeSend.createTime != null">
                AND ns.create_time &gt;= #{noticeSend.createTime, jdbcType=TIMESTAMP}
            </if>
            <if test="noticeSend.updateTime != null">
                AND ns.update_time &gt;= #{noticeSend.updateTime, jdbcType=TIMESTAMP}
            </if>
            <if test="1 == 1">
                AND nr.is_delete = 0
            </if>
            <if test="1 == 1">
                AND (ns.send_user_id = #{noticeSend.userId, jdbcType=BIGINT} AND ns.is_read = 0 OR
                nr.receive_user_id = #{noticeSend.userId, jdbcType=BIGINT} AND nr.is_read = 0)
            </if>
        </where>
        order by nr.is_reply asc, nr.update_time desc
    </select>

    <select id="selectNoticeReplys" resultType="com.cjwsjy.workreport.web.vo.NoticeReplyVo">
        select nr.id, nr.receive_user_id,su2.realname receive_user_name,
        nr.msg, nr.create_time, nr.update_time,nr.is_reply, so.org_name
        from notice_reply nr left join sys_user su2 on nr.receive_user_id = su2.id
        left join sys_org so on su2.org_id = so.id
        where nr.send_id = #{id} AND nr.is_read = 0
        <if test="isSelf == 0">
            AND nr.receive_user_id = #{userId}
        </if>
        order by nr.is_reply asc, nr.update_time desc
    </select>
