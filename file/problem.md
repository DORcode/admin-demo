<insert id="inserOrUpdate" parameterType="com.cjsjy.entity.GeoStat5t">
    MERGE INTO GEO_STAT_5T AS Target
    USING (values
        <foreach collection="list" item="item" separator=",">
            <trim prefix="(" suffix=")" suffixOverrides="," >
                #{item.objectid, jdbcType=INTEGER},
                #{item.stcd, jdbcType=VARCHAR},
                #{item.stNm, jdbcType=VARCHAR},
                #{item.stTp, jdbcType=VARCHAR},
                #{item.lttd, jdbcType=DECIMAL},
                #{item.ts, jdbcType=VARCHAR},
                #{item.lgtd, jdbcType=DECIMAL},
                #{item.shape, jdbcType=VARCHAR},
            </trim>
        </foreach>
            )
        AS Source (objectid, stcd,st_Nm,st_Tp,lttd,ts,lgtd,shape)
        ON Target.objectid = Source.objectid
        WHEN MATCHED THEN
        UPDATE SET stcd = Source.stcd,st_Nm = source.st_Nm, st_Tp = Source.st_Tp,  lttd= Source.lttd,
        ts= Source.ts,lgtd = Source.lgtd,shape=Source.shape
        WHEN NOT MATCHED THEN
        INSERT (objectid,stcd,st_Nm,st_Tp,lttd,ts,lgtd,shape) VALUES (Source.objectid,Source.stcd,Source.st_Nm,Source.st_Tp,Source.lttd,Source.ts,Source.lgtd,Source.shape);
    </insert>
    
    
    MERGE INTO GEO_STAT_5T AS Target
        USING (values
             
                  ( 34,
                    'NC000001',
                    '赣江西支入新建断面',
                    'ZZ',
                    28.81443245,
                    '2016-06-29 15:27:15.0000000',
                    '115.96495898',
                    'POINT (12909160.1851 3352048.5777)' ) 
             
                )
            AS Source (objectid, stcd,st_Nm,st_Tp,lttd,ts,lgtd,shape)
            ON Target.objectid = Source.objectid
            WHEN MATCHED THEN
            UPDATE SET stcd = Source.stcd,st_Nm = source.st_Nm, st_Tp = Source.st_Tp,  lttd= Source.lttd,
            ts= Source.ts,lgtd = Source.lgtd,shape=Source.shape
            WHEN NOT MATCHED THEN
            INSERT (objectid,stcd,st_Nm,st_Tp,lttd,ts,lgtd,shape) VALUES (Source.objectid,Source.stcd,Source.st_Nm,Source.st_Tp,Source.lttd,Source.ts,Source.lgtd,geometry::STGeomFromText(Source.shape, 4326));
            
            
            MERGE INTO  AS Target
                    USING (values
                    <foreach collection="list" item="item" separator=",">
                        <trim prefix="(" suffix=")" suffixOverrides="," >
                            #{item., jdbcType=INTEGER},
                            #{item., jdbcType=VARCHAR},
                            #{item., jdbcType=VARCHAR},
                            #{item., jdbcType=VARCHAR},
                            #{item., jdbcType=VARCHAR},
                            cast(#{item., jdbcType=DECIMAL} as decimal(38,8)),
                            cast(#{item., jdbcType=DECIMAL} as decimal(38,8)),
                        </trim>
                    </foreach>
                    )
                    AS Source ()
                    ON Target.objectid = Source.objectid
                    WHEN MATCHED THEN
                    UPDATE SET  = Source., = source.,  = Source.,  = cast(Source. as decimal(38,8)),
                    = Source., = cast(Source. as decimal(38,8))
                    WHEN NOT MATCHED THEN
                    INSERT () VALUES (Source.,Source.,Source.,Source.,Source.,Source.,Source.);