CREATE OR REPLACE PROCEDURE "PROC_GET_CODE"(upcode in varchar, name in varchar, glide out number)
--生成处方编号流水号，name 为流水号名称 time 避免查mybatis缓存
is
   PRAGMA AUTONOMOUS_TRANSACTION;
   m_glide number;
   m_rowcount number;
   m_Message varchar(200);
begin
  if(upcode = null)
    m_glide:=0;
  else
    m_glide:=10;
  m_rowcount:=1;
  if(upcode = null)
    glide:=0;
  else
    glide:=10;
  begin
  select glide into m_glide from sys_code where name=name and upcode=upcode for update;
	exception when no_data_found then m_rowcount:=0;
  end;
  if (m_rowcount = 1)
    then
    begin
    update sys_code set glide=glide+1 where numname=name; glide:=m_glide;
    end;
  else
    insert into sys_code(pk, upcode,name, glide) values(sys_code_pk_seq.nextval, upcode, name,2);
    if(upcode = null)
    glide:=1;
  else
    glide:=11;
  end if;
  commit;
  exception when others then glide:=0;m_Message := SUBSTR(SQLERRM, 1, 200); dbms_output.put_line(m_Message);
end;


<select id="getcode" statementType="CALLABLE">
    {call getnum
    #{name, jdbcType=VARCHAR, mode=IN},
    #{time, jdbcType=DECIMAL, mode=IN},
    #{glide, jdbcType=DECIMAL, mode=OUT})}
</select>


new DecimalFormat("00").format(num)